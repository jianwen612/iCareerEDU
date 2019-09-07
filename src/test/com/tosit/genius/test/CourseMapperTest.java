package com.tosit.genius.test;

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
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKeyWithBLOBs() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

    @Test
    public void listAll() throws Exception {
        List<Course> list=courseMapper.listAll();
        for (Course course:list
             ) {
            System.out.println(course.getCourseName());

        }
    }
    @Test
    public void searchByName() throws Exception {
        List<Course> list=courseMapper.selectByName("网");
        for (Course course:list
                ) {
            System.out.println(course.getCourseName());

        }
    }

}