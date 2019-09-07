package com.tosit.genius.service.impl;

import com.tosit.genius.dao.VideoMapper;
import com.tosit.genius.entity.Video;

import com.tosit.genius.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("videoService")
public class VideoServiceImpl implements VideoService{

    private VideoMapper videoMapper;

    @Autowired
    public VideoServiceImpl(VideoMapper videoMapper){
        this.videoMapper = videoMapper;
    }


    @Override
    public List<Video> getVideoByCourse(String courseId) {
        List<Video> videoList = videoMapper.listAll();
        List<Video> newList = new ArrayList<>();
        for(int i = 0; i < videoList.size(); i++){
            Video video=videoList.get(i);
            String videoCourseId=video.getVideoCourseId();
            if(courseId.equals(videoCourseId))
                newList.add(video);
        }
        return newList;
    }

    @Override
    public Boolean deleteVideo(String videoId) {
        int flag = videoMapper.deleteByPrimaryKey(videoId);
        if(flag==0)
            return false;
        else
            return true;
    }

    @Override
    public Boolean uploadVideo(Video video) {
        int flag = videoMapper.insert(video);
        if(flag==0)
            return false;
        else
            return true;
    }

    @Override
    public List<Video> selectVideoByName(String name) {
        return videoMapper.selectByName(name);
    }

    @Override
    public Video selectByVideoId(String videoId) {
        return videoMapper.selectByPrimaryKey(videoId);
    }

    @Override
    public List<Video> listAll() {
        return videoMapper.listAll();
    }

}

