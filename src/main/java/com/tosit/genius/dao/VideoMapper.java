package com.tosit.genius.dao;

import com.tosit.genius.entity.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {
    int deleteByPrimaryKey(String videoId);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(String videoId);

    List<Video> selectByName(String videoName);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKeyWithBLOBs(Video record);

    int updateByPrimaryKey(Video record);

    List<Video> listAll();

    int deleteByCourseId(String courseId);

}