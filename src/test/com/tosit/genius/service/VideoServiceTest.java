package com.tosit.genius.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})

public class VideoServiceTest {
    @Autowired
    VideoService videoService;
    @Test
    public void getVideoByCourse() throws Exception {
        System.out.println(videoService.getVideoByCourse("COU0001").get(0).getVideoName());
    }

    @Test
    public void deleteVideo() throws Exception {
        System.out.println(videoService.deleteVideo("VID0003"));
    }

}