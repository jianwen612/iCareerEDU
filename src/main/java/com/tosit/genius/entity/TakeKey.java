package com.tosit.genius.entity;

public class TakeKey {
    private String takeCourseId;

    private String takeUserId;

    public String getTakeCourseId() {
        return takeCourseId;
    }

    public void setTakeCourseId(String takeCourseId) {
        this.takeCourseId = takeCourseId == null ? null : takeCourseId.trim();
    }

    public String getTakeUserId() {
        return takeUserId;
    }

    public void setTakeUserId(String takeUserId) {
        this.takeUserId = takeUserId == null ? null : takeUserId.trim();
    }
}