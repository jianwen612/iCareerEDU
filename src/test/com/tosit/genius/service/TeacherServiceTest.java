package com.tosit.genius.service;

import com.tosit.genius.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})

public class TeacherServiceTest {
    @Autowired
    TeacherService teacherService;
    @Test
    public void checkTeacherIdentity() throws Exception {
        System.out.println(teacherService.checkTeacherIdentity("TEA0003", true));
    }

}