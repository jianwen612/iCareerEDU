package com.tosit.genius.entity;

import java.util.Date;

public class Video {
    private String videoId;

    private String videoPath;

    private String videoCourseId;

    private String videoName;

    private Date videoLength;

    private Date videoUploadDate;

    private Integer videoPlayCount;

    private String videoIntroduction;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath == null ? null : videoPath.trim();
    }

    public String getVideoCourseId() {
        return videoCourseId;
    }

    public void setVideoCourseId(String videoCourseId) {
        this.videoCourseId = videoCourseId == null ? null : videoCourseId.trim();
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public Date getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(Date videoLength) {
        this.videoLength = videoLength;
    }

    public Date getVideoUploadDate() {
        return videoUploadDate;
    }

    public void setVideoUploadDate(Date videoUploadDate) {
        this.videoUploadDate = videoUploadDate;
    }

    public Integer getVideoPlayCount() {
        return videoPlayCount;
    }

    public void setVideoPlayCount(Integer videoPlayCount) {
        this.videoPlayCount = videoPlayCount;
    }

    public String getVideoIntroduction() {
        return videoIntroduction;
    }

    public void setVideoIntroduction(String videoIntroduction) {
        this.videoIntroduction = videoIntroduction == null ? null : videoIntroduction.trim();
    }
}