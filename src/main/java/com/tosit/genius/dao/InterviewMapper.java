package com.tosit.genius.dao;

import com.tosit.genius.entity.Interview;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InterviewMapper {
    int deleteByPrimaryKey(String interviewId);

    int insert(Interview record);

    int insertSelective(Interview record);

    Interview selectByPrimaryKey(String interviewId);

    int updateByPrimaryKeySelective(Interview record);

    int updateByPrimaryKey(Interview record);

    List<Interview> listAll();
}