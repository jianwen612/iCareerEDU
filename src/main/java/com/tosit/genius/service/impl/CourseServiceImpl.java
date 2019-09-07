package com.tosit.genius.service.impl;

import com.tosit.genius.dao.*;
import com.tosit.genius.entity.Course;
import com.tosit.genius.entity.Subject;
import com.tosit.genius.entity.Teacher;
import com.tosit.genius.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service("courseService")
public class CourseServiceImpl implements CourseService{

    private CourseMapper courseMapper;
    private TeacherMapper teacherMapper;
    private SubjectMapper subjectMapper;
    private TakeMapper takeMapper;
    private VideoMapper videoMapper;

    @Autowired
    public CourseServiceImpl(CourseMapper courseMapper,TeacherMapper teacherMapper,
                             SubjectMapper subjectMapper, TakeMapper takeMapper,
                             VideoMapper videoMapper){
        this.courseMapper = courseMapper;
        this.teacherMapper = teacherMapper;
        this.subjectMapper = subjectMapper;
        this.takeMapper = takeMapper;
        this.videoMapper = videoMapper;
    }

    @Override
    public List<Course> getCourseByTeacherId(String teacherId) {
        List<Course> courseList = courseMapper.listAll();
        List<Course> newList = new ArrayList<>();
        for(int i = 0; i < courseList.size(); i++){
            if(teacherId.equals(courseList.get(i).getCourseTeacherId()))
                newList.add(courseList.get(i));
        }
        return newList;
    }

    @Override
    public Boolean addNewCourse(Course course) {
        int flag = courseMapper.insert(course);
        if(flag==0)
            return false;
        else
            return true;
    }

    @Override
    public Boolean deleteCourse(String courseId) {
        int flag = courseMapper.deleteByPrimaryKey(courseId);
        if(flag == 0)
            return false;
        takeMapper.deleteByCourseId(courseId);
        videoMapper.deleteByCourseId(courseId);
        return true;
    }

    @Override
    public Boolean updateCourse(Course newCourse) {
        int flag = courseMapper.updateByPrimaryKeySelective(newCourse);
        if(flag==0)
            return false;
        return true;
    }

    @Override
    public List<Course> selectByName(String name) {
        return courseMapper.selectByName(name);
    }


    @Override
    public Course selectById(String id) {
        return courseMapper.selectByPrimaryKey(id);
    }


}
