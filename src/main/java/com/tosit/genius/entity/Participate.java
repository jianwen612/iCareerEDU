package com.tosit.genius.entity;

import java.util.Date;

public class Participate extends ParticipateKey {
    private Date participateTime;

    private Integer grade;

    public Date getParticipateTime() {
        return participateTime;
    }

    public void setParticipateTime(Date participateTime) {
        this.participateTime = participateTime;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}