package com.tosit.genius.dao;

import com.tosit.genius.entity.TestQuestion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestQuestionMapper {
    int deleteByPrimaryKey(String questionId);

    int insert(TestQuestion record);

    int insertSelective(TestQuestion record);

    TestQuestion selectByPrimaryKey(String questionId);

    List<TestQuestion> selectByName(String questionName);

    List<TestQuestion> selectBySubjectName(String subjectId);

    int updateByPrimaryKeySelective(TestQuestion record);

    int updateByPrimaryKey(TestQuestion record);

    List<TestQuestion> listAll();
}