package com.lightleather.encoding;

public class EncodedEntity {
    String encodedMessage;

    public EncodedEntity(){
    }

    public EncodedEntity(String encodedMessage){
        this.encodedMessage = encodedMessage;
    }

    public String getEncodedMessage() {
        return encodedMessage;
    }

    public void setEncodedMessage(String encodedMessage) {
        this.encodedMessage = encodedMessage;
    }
}
