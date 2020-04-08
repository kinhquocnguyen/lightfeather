package com.lightleather.encoding;

public class MessageEntity {
    private Integer shift;
    private String message;

    public MessageEntity(Integer shift, String message){
        this.shift = shift;
        this.message = message;
    }

    public Integer getShift() {
        return shift;
    }

    public void setShift(Integer shift) {
        this.shift = shift;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
