package com.tosit.genius.entity;

import java.util.Date;

public class Course {
    private String courseId;

    private String courseTeacherId;

    private String courseSubjectId;

    private String courseName;

    private Date courseRegDate;

    private Date courseStartDate;

    private Date courseEndDate;

    private Integer courseTimes;

    private String courseIntroduction;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getCourseTeacherId() {
        return courseTeacherId;
    }

    public void setCourseTeacherId(String courseTeacherId) {
        this.courseTeacherId = courseTeacherId == null ? null : courseTeacherId.trim();
    }

    public String getCourseSubjectId() {
        return courseSubjectId;
    }

    public void setCourseSubjectId(String courseSubjectId) {
        this.courseSubjectId = courseSubjectId == null ? null : courseSubjectId.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Date getCourseRegDate() {
        return courseRegDate;
    }

    public void setCourseRegDate(Date courseRegDate) {
        this.courseRegDate = courseRegDate;
    }

    public Date getCourseStartDate() {
        return courseStartDate;
    }

    public void setCourseStartDate(Date courseStartDate) {
        this.courseStartDate = courseStartDate;
    }

    public Date getCourseEndDate() {
        return courseEndDate;
    }

    public void setCourseEndDate(Date courseEndDate) {
        this.courseEndDate = courseEndDate;
    }

    public Integer getCourseTimes() {
        return courseTimes;
    }

    public void setCourseTimes(Integer courseTimes) {
        this.courseTimes = courseTimes;
    }

    public String getCourseIntroduction() {
        return courseIntroduction;
    }

    public void setCourseIntroduction(String courseIntroduction) {
        this.courseIntroduction = courseIntroduction == null ? null : courseIntroduction.trim();
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseTeacherId='" + courseTeacherId + '\'' +
                ", courseSubjectId='" + courseSubjectId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseRegDate=" + courseRegDate +
                ", courseStartDate=" + courseStartDate +
                ", courseEndDate=" + courseEndDate +
                ", courseTimes=" + courseTimes +
                ", courseIntroduction='" + courseIntroduction + '\'' +
                '}';
    }
}