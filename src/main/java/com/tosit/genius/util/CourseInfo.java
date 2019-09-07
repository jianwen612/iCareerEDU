package com.tosit.genius.util;

import com.tosit.genius.entity.Course;
import com.tosit.genius.entity.Subject;
import com.tosit.genius.entity.Teacher;
import com.tosit.genius.service.SubjectService;
import com.tosit.genius.service.TakeService;
import com.tosit.genius.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseInfo  extends Course{

    private String teacherName;

    private String teacherEmail;
    private  String teacherUniversity;
    private  String teacherIntroduction;
    private  String subjectName;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherUniversity() {
        return teacherUniversity;
    }

    public void setTeacherUniversity(String teacherUniversity) {
        this.teacherUniversity = teacherUniversity;
    }

    public String getTeacherIntroduction() {
        return teacherIntroduction;
    }

    public void setTeacherIntroduction(String teacherIntroduction) {
        this.teacherIntroduction = teacherIntroduction;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
