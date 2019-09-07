package com.tosit.genius.entity;

import java.util.Date;

public class Interview {
    private String interviewId;

    private String interviewCompanyId;

    private String interviewName;

    private String interviewPosition;

    private String interviewCompany;

    private String interviewContent;

    private Date interviewTime;

    public String getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(String interviewId) {
        this.interviewId = interviewId == null ? null : interviewId.trim();
    }

    public String getInterviewCompanyId() {
        return interviewCompanyId;
    }

    public void setInterviewCompanyId(String interviewCompanyId) {
        this.interviewCompanyId = interviewCompanyId == null ? null : interviewCompanyId.trim();
    }

    public String getInterviewName() {
        return interviewName;
    }

    public void setInterviewName(String interviewName) {
        this.interviewName = interviewName == null ? null : interviewName.trim();
    }

    public String getInterviewPosition() {
        return interviewPosition;
    }

    public void setInterviewPosition(String interviewPosition) {
        this.interviewPosition = interviewPosition == null ? null : interviewPosition.trim();
    }

    public String getInterviewCompany() {
        return interviewCompany;
    }

    public void setInterviewCompany(String interviewCompany) {
        this.interviewCompany = interviewCompany == null ? null : interviewCompany.trim();
    }

    public String getInterviewContent() {
        return interviewContent;
    }

    public void setInterviewContent(String interviewContent) {
        this.interviewContent = interviewContent == null ? null : interviewContent.trim();
    }

    public Date getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(Date interviewTime) {
        this.interviewTime = interviewTime;
    }
}