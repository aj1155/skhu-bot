package me.gomko.api.controller.model.json;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MessagingActor {

    private Long id;

    /*
    @JsonCreator
    public MessagingActor(@JsonProperty("id") final Long id) {
        this.id = id;
    }
    */
    public MessagingActor(Long id){
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
