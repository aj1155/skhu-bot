package me.gomko.api.util;

/**
 * Created by Manki Kim on 2017-03-10.
 */
public enum MessageType {
    NOMANUAL("그 질문에 대해서는 아직 잘 모르겠어 공부 해올게 기다려줘!");

    private String message;

    MessageType(String message){
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
