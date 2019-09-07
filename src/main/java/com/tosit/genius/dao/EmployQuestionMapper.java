package com.tosit.genius.dao;

import com.tosit.genius.entity.EmployQuestion;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployQuestionMapper {
    int deleteByPrimaryKey(String employQuestionId);

    int insert(EmployQuestion record);

    int insertSelective(EmployQuestion record);

    EmployQuestion selectByPrimaryKey(String employQuestionId);

    int updateByPrimaryKeySelective(EmployQuestion record);

    int updateByPrimaryKey(EmployQuestion record);

    List<EmployQuestion> listAll();
}