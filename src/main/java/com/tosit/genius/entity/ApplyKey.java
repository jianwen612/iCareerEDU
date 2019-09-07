package com.tosit.genius.entity;

public class ApplyKey {
    private String applyUserId;

    private String applyAdId;

    public String getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId == null ? null : applyUserId.trim();
    }

    public String getApplyAdId() {
        return applyAdId;
    }

    public void setApplyAdId(String applyAdId) {
        this.applyAdId = applyAdId == null ? null : applyAdId.trim();
    }
}