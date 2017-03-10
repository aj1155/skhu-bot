package me.gomko.api.controller.model.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * Maps incoming message data received bei the registered facebook
 * webhook in {@code FacebookMessengerController}.
 * <p>
 * {
 * "object": "page",
 * "entry": [
 * {
 * "id": "250052192015902",
 * "time": 1458692752478,
 * "messaging": [
 * {
 * "sender": {
 * "id": "996148190503410"
 * },
 * "recipient": {
 * "id": "250052192015902"
 * },
 * "timestamp": 1460245672080,
 * "message": {
 * "mid": "mid.1460245671959:dad2ec9421b03d6f78",
 * "seq": 216,
 * "text": "hello"
 * }
 * }
 * ]
 * }
 * ]
 * }
 */
public class IncomingMessageData {

    private String object;
    private List<Entry> entry;

    @JsonCreator
    public IncomingMessageData(@JsonProperty("object") String object,
                               @JsonProperty("entry") List<Entry> entry) {
        this.object = object;
        this.entry = entry;
    }

    public String getObject() {
        return object;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
