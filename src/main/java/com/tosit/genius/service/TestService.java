package com.tosit.genius.service;

import com.tosit.genius.entity.Test;

import java.util.List;

/**
 * 考试业务对象
 */
public interface TestService {

    /**
     * 获取所有考试信息
     * @return
     */
    List<Test> listAllTests();

    /**
     * 通过testId获取考试信息
     * @param testId
     * @return
     */
    Test listTestsByTestsId(String testId);
}
