package com.tosit.genius.test;

import com.tosit.genius.dao.UserMapper;
import com.tosit.genius.entity.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;
    Logger logger= LoggerFactory.getLogger(UserMapperTest.class);
    @Test
    public void deleteByPrimaryKey() throws Exception {
    }
    @Test
    public void selectByName() throws Exception {

    }


    @Test
    public void insert() throws Exception {
        User user=userMapper.selectByPrimaryKey("1234567");
        if (user!=null)
        {
            System.out.println("already has\n");

        }
        else{
            user=new User();
            user.setUserPswd("1234567");
            user.setUserId("1234567");

            userMapper.insert(user);

        }
    }

    @Test
    public void insertSelective() throws Exception {


        User user=new User();
        user.setUserPswd("1234567");
        user.setUserId("1234567");

        userMapper.insert(user);


    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKeyWithBLOBs() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }



}
