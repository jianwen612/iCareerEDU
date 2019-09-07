package com.tosit.genius.service;

import com.tosit.genius.entity.Participate;

import java.util.List;

/**
 * 参与考试业务对象
 */
public interface ParticipateService {

    /**
     * 列出考试学生及成绩
     * @param testId
     * @return
     */
    List<Participate> selectGradesByTestId(String testId);


}
