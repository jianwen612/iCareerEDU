package com.tosit.genius.dao;

import com.tosit.genius.entity.TakeKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TakeMapper {
    int deleteByPrimaryKey(TakeKey key);

    int insert(TakeKey record);

    int insertSelective(TakeKey record);

    List<TakeKey> selectUserIdByCourseId(String courseId);

    List<TakeKey> selectCourseIdByUserId(String userId);

    List<TakeKey> listAll();

    int deleteByCourseId(String courseId);
}