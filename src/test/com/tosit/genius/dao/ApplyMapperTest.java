package com.tosit.genius.dao;

import com.tosit.genius.entity.Apply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)
public class ApplyMapperTest {
    @Autowired
    ApplyMapper applyMapper;
    @Test
    public void insertSelective() throws Exception {
        Apply apply = new Apply();
        apply.setApplyAdId("ADV0009");
        apply.setApplyUserId("USR0008");
        Date applyDate = new Date(2018-1900,3-1,25);
        apply.setApplyDate(applyDate);
        System.out.println(applyMapper.insertSelective(apply));
    }
    @Test
    public void listAll() throws Exception{
        System.out.println(applyMapper.listAll().get(0).getApplyDate());
    }

}
