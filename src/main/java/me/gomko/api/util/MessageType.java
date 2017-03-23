package me.gomko.api.util;

/**
 * Created by Manki Kim on 2017-03-10.
 */
public enum MessageType {
    NOMANUAL("그 질문에 대한 답변은 아직 부족합니다. 또는 맞춤법이나 문장 구성을 한번 확인 해주세요"),
    AMBIGUOUS("만으로는 부족합니다. 명사나 수식어를 붙여서 조금 더 자세하게 알려주세요!!");

    private String message;

    MessageType(String message){
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
