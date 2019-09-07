package com.tosit.genius.dao;

import com.tosit.genius.dao.SubjectMapper;
import com.tosit.genius.entity.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)
public class SubjectMapperTest {
    @Autowired
    SubjectMapper subjectMapper;
    @Test
    public void deleteByPrimaryKey() throws Exception {
        System.out.println(subjectMapper.deleteByPrimaryKey("SUB0003"));
    }

    @Test
    public void insertSelective() throws Exception {
        Subject subject = new Subject();
        subject.setSubjectId("SUB0003");
        subject.setSubjectName("英语");
        System.out.println(subjectMapper.insertSelective(subject));
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Subject subject = subjectMapper.selectByPrimaryKey("SUB0003");
        subject.setSubjectName("机械");
        System.out.println(subjectMapper.updateByPrimaryKeySelective(subject));
    }

    @Test
    public void listAll() throws Exception {
        List<Subject> subjectList = subjectMapper.listAll();
        System.out.println(subjectList.get(0).getSubjectId());
    }

}