package com.tosit.genius.dao;

import com.tosit.genius.dao.ReceiveMapper;
import com.tosit.genius.entity.Receive;
import com.tosit.genius.entity.ReceiveKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)
public class ReceiveMapperTest {
    @Autowired
    ReceiveMapper receiveMapper;
    @Test
    public void deleteByPrimaryKey() throws Exception {
        ReceiveKey key = new ReceiveKey();
        key.setReceiveUserId("USR0003");
        key.setReceiveInterviewId("INT0003");
        System.out.println(receiveMapper.deleteByPrimaryKey(key));
    }

    @Test
    public void insertSelective() throws Exception {
        Receive receive = new Receive();
        receive.setReceiveUserId("USR0003");
        receive.setReceiveInterviewId("INT0003");
        System.out.println(receiveMapper.insertSelective(receive));
    }

    @Test
    public void listAll() throws Exception {
        List<Receive> receiveList = receiveMapper.listAll();
        System.out.println(receiveList.get(0).getReceiveInterviewId());
    }

}