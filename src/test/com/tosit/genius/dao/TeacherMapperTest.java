package com.tosit.genius.dao;

import com.tosit.genius.dao.TeacherMapper;
import com.tosit.genius.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)

public class TeacherMapperTest {
    @Autowired
    TeacherMapper teacherMapper;
    @Test
    public void deleteByPrimaryKey() throws Exception {
        int flag = teacherMapper.deleteByPrimaryKey("TEA0003");
        System.out.println(flag);
    }

    @Test
    public void insertSelective() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setTeacherId("TEA0003");
        teacher.setTeacherName("海燕");
        teacher.setTeacherStatus(false);
        teacher.setTeacherSex(false);
        teacher.setTeacherEmail(null);
        teacher.setTeacherPswd("654321");
        teacher.setTeacherCertificate(null);
        int flag = teacherMapper.insertSelective(teacher);
        System.out.println(flag);

    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        Teacher teacher = teacherMapper.selectByPrimaryKey("TEA0001");
        System.out.println(teacher.getTeacherId());
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Teacher teacher = teacherMapper.selectByPrimaryKey("TEA0003");
        teacher.setTeacherPswd("123456");
        int flag = teacherMapper.updateByPrimaryKeySelective(teacher);
        System.out.println(flag);
    }

    @Test
    public void listAll() throws Exception{
        List<Teacher> teacherList = teacherMapper.listAll();
        System.out.println(teacherList.get(0).getTeacherId());
    }

    @Test
    public void selectByStatus() throws Exception{
        List<Teacher> teacherList = teacherMapper.selectByStatus(true);
        System.out.println(teacherList.get(0).getTeacherId());
    }

    @Test
    public void deleteByStatus() throws Exception{
        int flag = teacherMapper.deleteByStatus(false);
        System.out.println(flag);
    }
}
