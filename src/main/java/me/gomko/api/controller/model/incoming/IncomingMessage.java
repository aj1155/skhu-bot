package me.gomko.api.controller.model.incoming;

import me.gomko.api.controller.model.json.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;
import java.util.stream.Collectors;

public class IncomingMessage {

    private String object;
    private Long id;
    private Long time;
    private Long senderId;
    private Long recipientId;
    private Long timestamp;
    private String mid;
    private Integer seq;
    private String text;
    private  List<Attachment> attachments;

    public IncomingMessage(IncomingMessageData incomingMessageData) {
        this.object = incomingMessageData.getObject();

        Entry entry = incomingMessageData.getEntry().get(0);
        this.id = entry.getId();
        this.time = entry.getTime();

        Messaging messaging = entry.getMessaging().get(0);
        this.senderId = messaging.getSender().getId();
        this.recipientId = messaging.getRecipient().getId();
        this.timestamp = messaging.getTimestamp();

        Message message = messaging.getMessage();
        this.mid = message.getMid();
        this.seq = message.getSeq();
        this.text = message.getText();
        this.attachments = message.getAttachments().stream()
                .map(attachment -> new Attachment(attachment.getType(), attachment.getPayload()))
                .collect(Collectors.toList());
    }

    public String getObject() {
        return object;
    }

    public Long getId() {
        return id;
    }

    public Long getTime() {
        return time;
    }

    public Long getSenderId() {
        return senderId;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getMid() {
        return mid;
    }

    public Integer getSeq() {
        return seq;
    }

    public String getText() {
        return text;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
