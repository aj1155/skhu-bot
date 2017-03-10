package me.gomko.api.controller.model.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Message {

    private String mid;
    private Integer seq;
    private String text;

    private List<Attachment> attachments;

    @JsonCreator
    public Message(@JsonProperty("mid") String mid,
                   @JsonProperty("seq")  Integer seq,
                   @JsonProperty("text") String text,
                   @JsonProperty("attachments") List<Attachment> attachments) {
        this.mid = mid;
        this.seq = seq;
        this.text = text;
        this.attachments = Optional.ofNullable(attachments).orElse(new ArrayList<>());
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
