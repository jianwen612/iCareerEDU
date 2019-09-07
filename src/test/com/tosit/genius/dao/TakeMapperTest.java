package com.tosit.genius.dao;

import com.tosit.genius.dao.TakeMapper;
import com.tosit.genius.entity.TakeKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)
public class TakeMapperTest {

    @Autowired
    TakeMapper takeMapper;
    @Test
    public void deleteByPrimaryKey() throws Exception {
        TakeKey key = new TakeKey();
        key.setTakeUserId("USR0003");
        key.setTakeCourseId("COU0002");
        System.out.println(takeMapper.deleteByPrimaryKey(key));
    }

    @Test
    public void insertSelective() throws Exception {
        TakeKey key = new TakeKey();
        key.setTakeUserId("USR0003");
        key.setTakeCourseId("COU0002");
        System.out.println(takeMapper.insertSelective(key));
    }

    @Test
    public void listAll() throws Exception {
        List<TakeKey> takeKeyList = takeMapper.listAll();
        System.out.println(takeKeyList.get(0).getTakeCourseId());
    }

    @Test
    public void selectUserIdByCourseId() throws Exception {
        List<TakeKey> takeKeyList = takeMapper.selectUserIdByCourseId("COU0001");
        System.out.println(takeKeyList.get(0).getTakeCourseId());
    }

    @Test
    public void deleteByCourseId() throws Exception {
        System.out.println(takeMapper.deleteByCourseId("CsDB"));
    }
}