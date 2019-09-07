package com.tosit.genius.entity;

public class Test {
    private String testId;

    private String testCourseId;

    private String testName;

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId == null ? null : testId.trim();
    }

    public String getTestCourseId() {
        return testCourseId;
    }

    public void setTestCourseId(String testCourseId) {
        this.testCourseId = testCourseId == null ? null : testCourseId.trim();
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName == null ? null : testName.trim();
    }
}