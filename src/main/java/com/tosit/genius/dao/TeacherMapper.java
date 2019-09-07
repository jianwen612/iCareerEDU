package com.tosit.genius.dao;

import com.tosit.genius.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {
    int deleteByPrimaryKey(String teacherId);

    int deleteByStatus(Boolean teacherStatus);

    int deleteByName(String teacherName);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String teacherId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKeyWithBLOBs(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<Teacher> listAll();

    List<Teacher> selectByName(String teacherName);

    List<Teacher> selectByStatus(Boolean teacherStatus);
}