package com.tosit.genius.dao;


import com.tosit.genius.entity.Video;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)

public class VideoMapperTest {
    @Autowired
    VideoMapper videoMapper;

    Logger logger= LoggerFactory.getLogger(VideoMapperTest.class);
    @Test
    public void deleteByPrimaryKey() throws Exception {
        int flag = videoMapper.deleteByPrimaryKey("VID0002");
        System.out.println(flag);
    }

    @Test
    public void insertSelective() throws Exception {
        Video video = new Video();
        Date uploadDate = new SimpleDateFormat("yyyy-mm-dd").parse("2018-03-18");
        video.setVideoId("VID0002");
        video.setVideoCourseId("COU0001");
        video.setVideoPath("E:\\video\\video02");
        video.setVideoName("进程与线程");
        video.setVideoUploadDate(uploadDate);
        int flag = videoMapper.insertSelective(video);
        System.out.println(flag);
    }


    @Test
    public void selectByName() throws Exception {
        List<Video> videoList = videoMapper.selectByName("进程");
        System.out.println(videoList.get(0).getVideoName());
    }

    @Test
    public void selectByPrimaryKey() throws Exception{
        Video video = videoMapper.selectByPrimaryKey("VID0001");
        System.out.println(video.getVideoName());

    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {

        Video video = videoMapper.selectByPrimaryKey("VID0001");
        video.setVideoPath("E:\\video\\video01");
        int flag = videoMapper.updateByPrimaryKeySelective(video);
        System.out.println(flag);

    }

    @Test
    public void listAll() throws Exception {
        List<Video> videoList = videoMapper.listAll();
        System.out.println(videoList.get(0).getVideoId());
    }

}
