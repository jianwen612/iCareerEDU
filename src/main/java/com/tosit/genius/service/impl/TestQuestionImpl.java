package com.tosit.genius.service.impl;

import com.tosit.genius.dao.TestQuestionMapper;
import com.tosit.genius.entity.TestQuestion;
import com.tosit.genius.service.TestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("testQuestionService")
public class TestQuestionImpl implements TestQuestionService {

    private TestQuestionMapper testQuestionMapper;

    @Autowired
    public TestQuestionImpl(TestQuestionMapper testQuestionMapper){
        this.testQuestionMapper = testQuestionMapper;
    }

    @Override
    public List<TestQuestion> getAllTestQuestion() {
        return testQuestionMapper.listAll();
    }

    @Override
    public List<TestQuestion> getTestQuestionByName(String name) {

        List<TestQuestion> testQuestionList = testQuestionMapper.selectByName(name);
        testQuestionList.addAll(testQuestionMapper.selectBySubjectName(name));

        return testQuestionList;

    }
}
