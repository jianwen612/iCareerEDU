package com.tosit.genius.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})

public class TakeServiceTest {
    @Autowired
    TakeService takeService;
    @Test
    public void getAllStudentsByCourseId() throws Exception {
        System.out.println(takeService.getAllStudentsByCourseId("COU0001").get(0).getUserName());
    }

    @Test
    public void chooseCourse() throws Exception {
        System.out.println(takeService.chooseCourse("COU0003", "user1"));
    }

    @Test
    public void getCourseByUserId() throws Exception {
        System.out.println(takeService.getCourseByUserId("user1").get(1).getCourseId());
    }

}