package com.tosit.genius.entity;

public class Advertisement {
    private String adId;

    private String adCompanyId;

    private String adTitle;

    private Boolean adStatus;

    private String adContent;

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId == null ? null : adId.trim();
    }

    public String getAdCompanyId() {
        return adCompanyId;
    }

    public void setAdCompanyId(String adCompanyId) {
        this.adCompanyId = adCompanyId == null ? null : adCompanyId.trim();
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle == null ? null : adTitle.trim();
    }

    public Boolean getAdStatus() {
        return adStatus;
    }

    public void setAdStatus(Boolean adStatus) {
        this.adStatus = adStatus;
    }

    public String getAdContent() {
        return adContent;
    }

    public void setAdContent(String adContent) {
        this.adContent = adContent == null ? null : adContent.trim();
    }
}