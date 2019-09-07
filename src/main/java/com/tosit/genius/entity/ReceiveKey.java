package com.tosit.genius.entity;

public class ReceiveKey {
    private String receiveUserId;

    private String receiveInterviewId;

    public String getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(String receiveUserId) {
        this.receiveUserId = receiveUserId == null ? null : receiveUserId.trim();
    }

    public String getReceiveInterviewId() {
        return receiveInterviewId;
    }

    public void setReceiveInterviewId(String receiveInterviewId) {
        this.receiveInterviewId = receiveInterviewId == null ? null : receiveInterviewId.trim();
    }
}