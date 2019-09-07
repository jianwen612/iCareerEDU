package com.tosit.genius.entity;

public class AdCheckKey {
    private String adCheckAdId;

    private String adCheckAdminId;

    public String getAdCheckAdId() {
        return adCheckAdId;
    }

    public void setAdCheckAdId(String adCheckAdId) {
        this.adCheckAdId = adCheckAdId == null ? null : adCheckAdId.trim();
    }

    public String getAdCheckAdminId() {
        return adCheckAdminId;
    }

    public void setAdCheckAdminId(String adCheckAdminId) {
        this.adCheckAdminId = adCheckAdminId == null ? null : adCheckAdminId.trim();
    }
}