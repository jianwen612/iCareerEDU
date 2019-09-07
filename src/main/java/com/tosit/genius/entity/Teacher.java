package com.tosit.genius.entity;

public class Teacher {
    private String teacherId;

    private String teacherName;

    private String teacherEmail;

    private String teacherPswd;

    private Boolean teacherSex;

    private String teacherCertificate;

    private String teacherUniversity;

    private String teacherUniEmpno;

    private Boolean teacherStatus;

    private String teacherIntroduction;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail == null ? null : teacherEmail.trim();
    }

    public String getTeacherPswd() {
        return teacherPswd;
    }

    public void setTeacherPswd(String teacherPswd) {
        this.teacherPswd = teacherPswd == null ? null : teacherPswd.trim();
    }

    public Boolean getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(Boolean teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherCertificate() {
        return teacherCertificate;
    }

    public void setTeacherCertificate(String teacherCertificate) {
        this.teacherCertificate = teacherCertificate == null ? null : teacherCertificate.trim();
    }

    public String getTeacherUniversity() {
        return teacherUniversity;
    }

    public void setTeacherUniversity(String teacherUniversity) {
        this.teacherUniversity = teacherUniversity == null ? null : teacherUniversity.trim();
    }

    public String getTeacherUniEmpno() {
        return teacherUniEmpno;
    }

    public void setTeacherUniEmpno(String teacherUniEmpno) {
        this.teacherUniEmpno = teacherUniEmpno == null ? null : teacherUniEmpno.trim();
    }

    public Boolean getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(Boolean teacherStatus) {
        this.teacherStatus = teacherStatus;
    }

    public String getTeacherIntroduction() {
        return teacherIntroduction;
    }

    public void setTeacherIntroduction(String teacherIntroduction) {
        this.teacherIntroduction = teacherIntroduction == null ? null : teacherIntroduction.trim();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherEmail='" + teacherEmail + '\'' +
                ", teacherPswd='" + teacherPswd + '\'' +
                ", teacherSex=" + teacherSex +
                ", teacherCertificate='" + teacherCertificate + '\'' +
                ", teacherUniversity='" + teacherUniversity + '\'' +
                ", teacherUniEmpno='" + teacherUniEmpno + '\'' +
                ", teacherStatus=" + teacherStatus +
                ", teacherIntroduction='" + teacherIntroduction + '\'' +
                '}';
    }
}