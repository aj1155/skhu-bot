package me.gomko.api.controller.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Messaging {

    private MessagingActor sender;
    private MessagingActor recipient;
    private Long timestamp;
    private Message message;

    public Messaging(@JsonProperty("sender") MessagingActor sender,
                     @JsonProperty("recipient") MessagingActor recipient,
                     @JsonProperty("timestamp") Long timestamp,
                     @JsonProperty("message") Message message) {
        this.sender = sender;
        this.recipient = recipient;
        this.timestamp = timestamp;
        this.message = message;
    }

    public MessagingActor getSender() {
        return sender;
    }

    public MessagingActor getRecipient() {
        return recipient;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Message getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
