package com.tosit.genius.entity;

public class TeacherCheckKey {
    private String teacherCheckTeacherId;

    private String teacherCheckAdminId;

    public String getTeacherCheckTeacherId() {
        return teacherCheckTeacherId;
    }

    public void setTeacherCheckTeacherId(String teacherCheckTeacherId) {
        this.teacherCheckTeacherId = teacherCheckTeacherId == null ? null : teacherCheckTeacherId.trim();
    }

    public String getTeacherCheckAdminId() {
        return teacherCheckAdminId;
    }

    public void setTeacherCheckAdminId(String teacherCheckAdminId) {
        this.teacherCheckAdminId = teacherCheckAdminId == null ? null : teacherCheckAdminId.trim();
    }
}