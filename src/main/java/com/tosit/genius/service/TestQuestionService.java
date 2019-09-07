package com.tosit.genius.service;

import com.tosit.genius.entity.TestQuestion;

import java.util.List;

/**
 * 题库业务对象
 */
public interface TestQuestionService {

    /**
     * 得到全部试题列表
     * @return
     */
    List<TestQuestion> getAllTestQuestion();

    /**
     * 搜索得到相似试题列表
     * @param name
     * @return
     */
    List<TestQuestion> getTestQuestionByName(String name);
}
