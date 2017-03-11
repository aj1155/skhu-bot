package me.gomko.api.controller.model.outgoing;

import me.gomko.api.controller.model.json.MessagingActor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by Manki Kim on 2017-03-11.
 */
public class OutgoingButton {

    private MessagingActor recipient;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
