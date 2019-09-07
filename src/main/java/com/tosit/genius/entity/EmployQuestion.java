package com.tosit.genius.entity;

public class EmployQuestion {
    private String employQuestionId;

    private String employCompanyId;

    private String employQuestionName;

    private String employQuestionAnswer;

    public String getEmployQuestionId() {
        return employQuestionId;
    }

    public void setEmployQuestionId(String employQuestionId) {
        this.employQuestionId = employQuestionId == null ? null : employQuestionId.trim();
    }

    public String getEmployCompanyId() {
        return employCompanyId;
    }

    public void setEmployCompanyId(String employCompanyId) {
        this.employCompanyId = employCompanyId == null ? null : employCompanyId.trim();
    }

    public String getEmployQuestionName() {
        return employQuestionName;
    }

    public void setEmployQuestionName(String employQuestionName) {
        this.employQuestionName = employQuestionName == null ? null : employQuestionName.trim();
    }

    public String getEmployQuestionAnswer() {
        return employQuestionAnswer;
    }

    public void setEmployQuestionAnswer(String employQuestionAnswer) {
        this.employQuestionAnswer = employQuestionAnswer == null ? null : employQuestionAnswer.trim();
    }
}