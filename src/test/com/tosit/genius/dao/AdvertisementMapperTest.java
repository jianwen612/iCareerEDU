package com.tosit.genius.dao;

import com.tosit.genius.entity.Advertisement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)
public class AdvertisementMapperTest {
    @Autowired
    AdvertisementMapper advertisementMapper;

    @Test
    public void selectByName() throws Exception {
        System.out.println(advertisementMapper.selectByName("广").get(0).getAdId());

    }

}