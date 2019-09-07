package com.tosit.genius.entity;

public class ConsistKey {
    private String consistQuestionId;

    private String consistTestId;

    public String getConsistQuestionId() {
        return consistQuestionId;
    }

    public void setConsistQuestionId(String consistQuestionId) {
        this.consistQuestionId = consistQuestionId == null ? null : consistQuestionId.trim();
    }

    public String getConsistTestId() {
        return consistTestId;
    }

    public void setConsistTestId(String consistTestId) {
        this.consistTestId = consistTestId == null ? null : consistTestId.trim();
    }
}