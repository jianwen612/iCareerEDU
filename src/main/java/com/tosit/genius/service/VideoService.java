package com.tosit.genius.service;

import com.tosit.genius.entity.Video;

import java.util.List;

/**
 * 教学视频业务对象
 */
public interface VideoService {

    /**
     * 根据课程ID显示视频
     * @param courseId
     * @return
     */
    List<Video> getVideoByCourse(String courseId);

    /**
     * 删除视频
     * @param videoId
     * @return
     */
    Boolean deleteVideo(String videoId);

    /**
     * 上传视频
     * @param video
     * @return
     */
    Boolean uploadVideo(Video video);

    /**
     * 搜索视频
     * @return
     */
    List<Video> selectVideoByName(String name);
    /**
     * 根据视频ID获取视频
     * @param videoId
     * @return
     */
    Video selectByVideoId(String videoId);

    /**
     * 获得全部视频信息
     * @return
     */
    List<Video> listAll();


}
