package com.tosit.genius.dao;

import com.tosit.genius.entity.TeacherCheck;
import com.tosit.genius.entity.TeacherCheckKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherCheckMapper {

    int deleteByPrimaryKey(TeacherCheckKey key);

    int insert(TeacherCheck record);

    int insertSelective(TeacherCheck record);

    TeacherCheck selectByPrimaryKey(TeacherCheck key);

    int updateByPrimaryKeySelective(TeacherCheck record);

    int updateByPrimaryKey(TeacherCheck record);

    List<TeacherCheck> selectByTeacherKey(String teacherId);


}