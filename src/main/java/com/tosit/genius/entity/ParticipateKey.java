package com.tosit.genius.entity;

public class ParticipateKey {
    private String participateTestId;

    private String participateUserId;

    public String getParticipateTestId() {
        return participateTestId;
    }

    public void setParticipateTestId(String participateTestId) {
        this.participateTestId = participateTestId == null ? null : participateTestId.trim();
    }

    public String getParticipateUserId() {
        return participateUserId;
    }

    public void setParticipateUserId(String participateUserId) {
        this.participateUserId = participateUserId == null ? null : participateUserId.trim();
    }
}