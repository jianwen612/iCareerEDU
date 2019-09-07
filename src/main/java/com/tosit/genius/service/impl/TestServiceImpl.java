package com.tosit.genius.service.impl;

import com.tosit.genius.dao.TakeMapper;
import com.tosit.genius.dao.TestMapper;
import com.tosit.genius.entity.Test;
import com.tosit.genius.entity.User;
import com.tosit.genius.service.TakeService;
import com.tosit.genius.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("testService")
public class TestServiceImpl implements TestService {

    private TestMapper testMapper;

    @Autowired
    public TestServiceImpl(TestMapper testMapper){
        this.testMapper = testMapper;
    }



    @Override
    public List<Test> listAllTests() {
        return testMapper.listAll();
    }

    @Override
    public Test listTestsByTestsId(String testId) {

        return testMapper.selectByPrimaryKey(testId);
    }
}
