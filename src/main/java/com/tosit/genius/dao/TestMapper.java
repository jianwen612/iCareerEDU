package com.tosit.genius.dao;

import com.tosit.genius.entity.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {
    int deleteByPrimaryKey(String testId);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(String testId);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);

    List<Test> listAll();

    List<Test> selectByCourseName(String courseName);

    List<Test> selectByTestName(String testName);
}