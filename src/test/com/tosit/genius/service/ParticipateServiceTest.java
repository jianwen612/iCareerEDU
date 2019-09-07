package com.tosit.genius.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})

public class ParticipateServiceTest {
    @Autowired
    ParticipateService participateService;
    @Test
    public void selectGradesByTestId() throws Exception {
        System.out.println(participateService.selectGradesByTestId("TST0001").get(1).getGrade());
    }

}