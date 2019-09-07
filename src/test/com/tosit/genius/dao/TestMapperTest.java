package com.tosit.genius.dao;

import com.tosit.genius.dao.TestMapper;
import com.tosit.genius.entity.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)
public class TestMapperTest {
    @Autowired
    TestMapper testMapper;
    @org.junit.Test
    public void deleteByPrimaryKey() throws Exception {
        int flag = testMapper.deleteByPrimaryKey("TST0002");
        System.out.println(flag);
    }

    @org.junit.Test
    public void insertSelective() throws Exception {
        Test test = new Test();
        test.setTestId("TST0002");
        test.setTestCourseId("COU0002");
        int flag = testMapper.insertSelective(test);
        System.out.println(flag);
    }

    @org.junit.Test
    public void selectByPrimaryKey() throws Exception {
        Test test = testMapper.selectByPrimaryKey("TST0001");
        System.out.println(test.getTestCourseId());
    }

    @org.junit.Test
    public void updateByPrimaryKeySelective() throws Exception {
        Test test = testMapper.selectByPrimaryKey("TST0002");
        test.setTestCourseId("COU0003");
        int flag = testMapper.updateByPrimaryKeySelective(test);
        System.out.println(flag);
    }

    @org.junit.Test
    public void listAll() throws Exception {
        List<com.tosit.genius.entity.Test> testList = testMapper.listAll();
        System.out.println(testList.get(0).getTestId());
    }

    @org.junit.Test
    public void selectByCourseName() throws Exception {
        List<com.tosit.genius.entity.Test> testList = testMapper.selectByCourseName("计算");
        System.out.println(testList.get(0).getTestId());
    }

    @org.junit.Test
    public void selectByTestName() throws Exception {
        List<com.tosit.genius.entity.Test> testList = testMapper.selectByTestName("操作");
        System.out.println(testList.get(0).getTestId());
    }

}
