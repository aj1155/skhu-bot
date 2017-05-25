package me.gomko.api.controller.model.outgoing;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Manki Kim on 2017-03-23.
 */
@Data
public class OutgoingImage {

    private final MessagingActor recipient;
    private final Message message;

    public OutgoingImage(final Long recipientId, final String text) {
        this.recipient = new MessagingActor(recipientId);
        Map<String, Object> attachment = new HashMap<>();
        Map<String, Object> payload = new HashMap<>();
        attachment.put("type","image");
        payload.put("url",text);
        attachment.put("payload",payload);
        message = new Message(attachment);

    }

    private static class MessagingActor {
        private final Long id;

        public MessagingActor(final Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }

    private static class Message {

        private final Map<String,Object> attachment;

        public Message(final Map<String,Object> attachment) {
            this.attachment = attachment;
        }

        public Map<String,Object> getAttachment() {
            return attachment;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }

}
