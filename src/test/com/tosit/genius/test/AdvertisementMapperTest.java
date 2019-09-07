package com.tosit.genius.test;

import com.tosit.genius.dao.AdvertisementMapper;
import com.tosit.genius.entity.Advertisement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)
public class AdvertisementMapperTest {
    @Autowired
    AdvertisementMapper advertisementMapper;

    @Test
    public void listALL() throws Exception {
        List<Advertisement> list=advertisementMapper.listAll();
        for (Advertisement advertisement:list
             ) {
            System.out.println(advertisement.getAdId());

        }

    }


    
    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByExampleWithBLOBs() throws Exception {
    }

    @Test
    public void searchByTitle() throws Exception {
        List<Advertisement> advertisement=
                advertisementMapper.selectByName("广告");
        System.out.println(advertisement.get(0).getAdTitle());


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