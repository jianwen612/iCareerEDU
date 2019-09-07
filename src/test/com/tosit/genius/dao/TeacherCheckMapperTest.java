package com.tosit.genius.dao;

import com.tosit.genius.dao.TeacherCheckMapper;
import com.tosit.genius.entity.TeacherCheck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)
public class TeacherCheckMapperTest {
    @Autowired
    TeacherCheckMapper teacherCheckMapper;
    @Test
    public void insertSelective() throws Exception {
        TeacherCheck teacherCheck = new TeacherCheck();
        teacherCheck.setTeacherCheckTeacherId("TEA0003");
        teacherCheck.setTeacherCheckAdminId("ADMIN02");
        teacherCheck.setIspassed(false);
        int flag = teacherCheckMapper.insertSelective(teacherCheck);
        System.out.println(flag);
    }

    @Test
    public void selectByTeacherKey() throws Exception {
        List<TeacherCheck> teacherCheckList = teacherCheckMapper.selectByTeacherKey("TEA0003");
        System.out.println(teacherCheckList.get(0).getIspassed());
    }

}