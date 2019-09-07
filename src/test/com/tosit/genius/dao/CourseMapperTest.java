package com.tosit.genius.dao;

import com.tosit.genius.dao.CourseMapper;
import com.tosit.genius.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)
public class CourseMapperTest {
    @Autowired
    CourseMapper courseMapper;
    @Test
    public void deleteByPrimaryKey() throws Exception {
        System.out.println(courseMapper.deleteByPrimaryKey("COU4005"));
    }

    @Test
    public void insertSelective() throws Exception {
        Course course = new Course();
        course.setCourseId("COU4005");
        course.setCourseTeacherId("TEA0004");
        course.setCourseSubjectId("SUB0003");
        System.out.println(courseMapper.insertSelective(course));
    }

    @Test
    public void listAll() throws Exception {
        List<Course> courseList= courseMapper.listAll();
        System.out.println(courseList.get(0).getCourseTeacherId());
    }

    @Test
    public void selectByName() throws Exception{
        System.out.println(courseMapper.selectByName("经济").get(0).getCourseId());
    }

}