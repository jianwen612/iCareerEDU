package com.tosit.genius.dao;

import com.tosit.genius.dao.TestQuestionMapper;
import com.tosit.genius.entity.TestQuestion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)


public class TestQuestionMapperTest {
    @Autowired
    TestQuestionMapper testQuestionMapper;
    @Test
    public void deleteByPrimaryKey() throws Exception {
        int flag = testQuestionMapper.deleteByPrimaryKey("TQU0003");
        System.out.println(flag);
    }

    @Test
    public void insertSelective() throws Exception {
        TestQuestion testQuestion = new TestQuestion();
        testQuestion.setQuestionId("TQU0003");
        testQuestion.setQuestionSubjectId("SUB0001");
        int flag = testQuestionMapper.insertSelective(testQuestion);
        System.out.println(flag);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        TestQuestion testQuestion = testQuestionMapper.selectByPrimaryKey("TQU0003");
        System.out.println(testQuestion.getQuestionId());
    }

    @Test
    public void selectByName() throws Exception {
        List<TestQuestion> testQuestionList = testQuestionMapper.selectByName("进程");
        System.out.println(testQuestionList.get(0).getQuestionAnswer());
    }

    @Test
    public void selectBySubjectName() throws Exception {
        List<TestQuestion> testQuestionList = testQuestionMapper.selectBySubjectName("计算机");
        System.out.println(testQuestionList.get(1).getQuestionAnswer());
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        TestQuestion testQuestion = testQuestionMapper.selectByPrimaryKey("TQU0003");
        testQuestion.setQuestionSubjectId("SUB0002");
        int flag = testQuestionMapper.updateByPrimaryKeySelective(testQuestion);
        System.out.println(flag);
    }

    @Test
    public void listAll() throws Exception {
        List<TestQuestion> testQuestionList = testQuestionMapper.listAll();
        System.out.println(testQuestionList.get(0).getQuestionName());
    }

}
