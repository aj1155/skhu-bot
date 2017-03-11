package me.gomko.api.controller.model.outgoing;

import me.gomko.api.controller.model.json.MessagingActor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OutgoingMessage {

    private MessagingActor recipient;
    private Message message;

    public OutgoingMessage(Long recipientId,  String text) {
        this.recipient = new MessagingActor(recipientId);
        this.message = new Message(text);
    }

    public MessagingActor getRecipient() {
        return recipient;
    }

    public Message getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    private static class Message {

        private final String text;

        public Message(final String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }
}
