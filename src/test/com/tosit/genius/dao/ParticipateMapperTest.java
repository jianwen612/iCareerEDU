package com.tosit.genius.dao;

import com.tosit.genius.dao.ParticipateMapper;
import com.tosit.genius.entity.Participate;
import com.tosit.genius.entity.ParticipateKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)
public class ParticipateMapperTest {
    @Autowired
    ParticipateMapper participateMapper;
    @Test
    public void insertSelective() throws Exception {
        Participate participate = new Participate();
        participate.setParticipateTestId("TST0001");
        participate.setParticipateUserId("USR0003");
        System.out.println(participateMapper.insertSelective(participate));
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        ParticipateKey participateKey = new ParticipateKey();
        participateKey.setParticipateTestId("TST0001");
        participateKey.setParticipateUserId("USR0003");
        Participate participate = participateMapper.selectByPrimaryKey(participateKey);
        participate.setGrade(97);
        System.out.println(participateMapper.updateByPrimaryKeySelective(participate));
    }

    @Test
    public void listAll() throws Exception {
        List<Participate> participateList = participateMapper.listAll();
        System.out.println(participateList.get(0).getParticipateTestId());
    }

}