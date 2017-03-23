package me.gomko.api.messaging;

import me.gomko.api.controller.model.incoming.IncomingMessage;
import me.gomko.api.controller.model.outgoing.OutgoingMessage;
import me.gomko.api.controller.model.json.IncomingMessageData;
import me.gomko.api.repository.ManualRepository;
import me.gomko.api.service.AnalysisMessageService;
import me.gomko.api.util.ManualType;
import me.gomko.api.util.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

@Component
public class IncomingMessageHandler {

    private static final Logger LOG = LoggerFactory.getLogger(IncomingMessageHandler.class);

    private RestTemplate restTemplate;
    private String fbAccessToken;

    @Autowired
    private AnalysisMessageService analysisMessageService;

    @Autowired
    private ManualRepository manualRepository;

    @Autowired
    public IncomingMessageHandler( RestTemplate restTemplate,
                                  @Value("${fb.accesstoken}") String fbAccessToken) {
        this.restTemplate = requireNonNull(restTemplate);
        this.fbAccessToken = requireNonNull(fbAccessToken);
    }

    public ResponseEntity<?> handleMessage(IncomingMessageData incomingMessageData) {
        LOG.info("Handle incoming message data: {}", incomingMessageData.toString());
        IncomingMessage incomingMessage = mapIncomingMessage(incomingMessageData);
        LOG.info("Mapped incoming message: {}", incomingMessage.toString());
        ManualType type = this.analysisMessageService.analysisType(incomingMessage.getText());
        System.out.println(type);
        OutgoingMessage outgoingMessage;
        switch (type){
            case TEXT:
                outgoingMessage = createOutgoingMessage(incomingMessage.getSenderId(), incomingMessage.getText());
                System.out.println(outgoingMessage);
                return sendTextMessage(outgoingMessage);
            case AMBIGUOUS:
                outgoingMessage = new OutgoingMessage(incomingMessage.getSenderId(), incomingMessage.getText()+" "+MessageType.AMBIGUOUS.getMessage());
                System.out.println(outgoingMessage);
                return sendTextMessage(outgoingMessage);
            case BUTTON:
                break;
        }
        outgoingMessage = new OutgoingMessage(incomingMessage.getSenderId(), MessageType.NOMANUAL.getMessage());
        return sendTextMessage(outgoingMessage);
    }

    private IncomingMessage mapIncomingMessage(IncomingMessageData incomingMessageData) {
        return new IncomingMessage(incomingMessageData);
    }

    private OutgoingMessage createOutgoingMessage(Long recipientId,String text) {
        String outgoingMessageText = this.analysisMessageService.analysisMessage(text);
        //final String outgoingMessageText = createOutgoingMessageText(text);
        return new OutgoingMessage(recipientId, outgoingMessageText);
    }

    private static String createOutgoingMessageText(String text) {
        return format("%s", text);
    }

    private ResponseEntity<?> sendTextMessage(OutgoingMessage outgoingMessage) {
        LOG.info("Trying to send message: {}", outgoingMessage);
        String url = format("https://graph.facebook.com/v2.6/me/messages?access_token=%s", fbAccessToken);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<OutgoingMessage> requestEntity = new HttpEntity<>(outgoingMessage, headers);
        System.out.println("request값:"+requestEntity);
        ResponseEntity<?> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Object.class);
        //ResponseEntity response = ResponseEntity.ok("okey");
        LOG.info("Response: body={}, status={}", response.getBody(), response.getStatusCode());
        return response;
    }

    private ResponseEntity<?> sendButtonTemplate(OutgoingMessage outgoingMessage){
        LOG.info("Trying to send message: {}", outgoingMessage);
        String url = format("https://graph.facebook.com/v2.6/me/messages?access_token=%s", fbAccessToken);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<OutgoingMessage> requestEntity = new HttpEntity<>(outgoingMessage, headers);
        ResponseEntity<?> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Object.class);
        LOG.info("Response: body={}, status={}", response.getBody(), response.getStatusCode());
        return response;
    }
}
