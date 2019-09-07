package com.tosit.genius.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})

public class InterviewServiceTest {
    @Autowired
    InterviewService interviewService;
    @Test
    public void getInterviewByUserId() throws Exception {
        System.out.println(interviewService.getInterviewByUserId("USR0001").get(0).getInterviewId());
    }

    @Test
    public void getInterviewByCompanyId() throws Exception {
        System.out.println(interviewService.getInterviewByCompanyId("COM0001").get(0).getInterviewId());
    }

}