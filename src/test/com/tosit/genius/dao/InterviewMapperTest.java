package com.tosit.genius.dao;

import com.tosit.genius.dao.InterviewMapper;
import com.tosit.genius.entity.Interview;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)
public class InterviewMapperTest {
    @Autowired
    InterviewMapper interviewMapper;
    @Test
    public void deleteByPrimaryKey() throws Exception {
        System.out.println(interviewMapper.deleteByPrimaryKey("INT0003"));
    }

    @Test
    public void insertSelective() throws Exception {
        Interview interview = new Interview();
        interview.setInterviewId("INT0003");
        interview.setInterviewCompanyId("COM0002");
        interview.setInterviewTime(null);
        interview.setInterviewCompany(null);
        interview.setInterviewContent(null);
        interview.setInterviewPosition(null);
        interview.setInterviewName(null);
        System.out.println(interviewMapper.insertSelective(interview));
    }

    @Test
    public void listAll() throws Exception {
        List<Interview> interviewList = interviewMapper.listAll();
        System.out.println(interviewList.get(0).getInterviewCompany());
    }

}