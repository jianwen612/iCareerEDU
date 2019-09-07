package com.tosit.genius.dao;

import com.tosit.genius.dao.EmployQuestionMapper;
import com.tosit.genius.entity.EmployQuestion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)
public class EmployQuestionMapperTest {
    @Autowired
    EmployQuestionMapper employQuestionMapper;
    @Test
    public void insertSelective() throws Exception {
        EmployQuestion employQuestion = new EmployQuestion();
        employQuestion.setEmployCompanyId("COM0001");
        employQuestion.setEmployQuestionId("EQU0003");
        System.out.println(employQuestionMapper.insertSelective(employQuestion));
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        EmployQuestion employQuestion = employQuestionMapper.selectByPrimaryKey("EQU0003");
        employQuestion.setEmployCompanyId("COM0002");
        System.out.println(employQuestionMapper.updateByPrimaryKeySelective(employQuestion));
    }

    @Test
    public void listAll() throws Exception {
        List<EmployQuestion> employQuestions = employQuestionMapper.listAll();
        System.out.println(employQuestions.get(0).getEmployCompanyId());
    }

}