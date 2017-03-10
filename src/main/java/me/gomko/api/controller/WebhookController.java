package me.gomko.api.controller;

import me.gomko.api.messaging.IncomingMessageHandler;
import me.gomko.api.model.json.IncomingMessageData;
import me.gomko.api.service.FBVerificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;

/**
 * Created by Manki Kim on 2017-03-08
 * email : aj1155@naver.com.
 */
@RestController
@RequestMapping(value = "/api/v1/webhook")
public class WebhookController {

    private static final Logger LOG = LoggerFactory.getLogger(WebhookController.class);

    @Autowired
    private FBVerificationService fbVerificationService;
    @Autowired
    private IncomingMessageHandler incomingMessageHandler;


    @GetMapping("")
    public String fbMessengerHook(@RequestParam(name = "hub.verify_token") final String verifyToken,
                                  @RequestParam(name = "hub.challenge") final String challenge) {
        LOG.info("Received Facebook verification request, hub.verify_token={}, hub.challenge={}", verifyToken, challenge);
        return fbVerificationService.verifyWebhook(verifyToken, challenge);
    }

    @PostMapping(value = "")
    public ResponseEntity<Void> handleMessage(@RequestBody final IncomingMessageData incomingMessageData) {
        LOG.info("Received message data: {}", incomingMessageData);
        final ResponseEntity<?> responseEntity = incomingMessageHandler.handleMessage(incomingMessageData);
        if(!responseEntity.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException(format("Cannot send message, status: %s", responseEntity.getStatusCode()));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
