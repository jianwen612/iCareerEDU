package com.tosit.genius.entity;

public class TestQuestion {
    private String questionId;

    private String questionSubjectId;

    private String questionName;

    private String questionAnswer;

    private String questionType;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }

    public String getQuestionSubjectId() {
        return questionSubjectId;
    }

    public void setQuestionSubjectId(String questionSubjectId) {
        this.questionSubjectId = questionSubjectId == null ? null : questionSubjectId.trim();
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName == null ? null : questionName.trim();
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer == null ? null : questionAnswer.trim();
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType == null ? null : questionType.trim();
    }
}