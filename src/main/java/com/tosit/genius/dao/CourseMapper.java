package com.tosit.genius.dao;

import com.tosit.genius.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseMapper {
    int deleteByPrimaryKey(String courseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(String courseId);

    List<Course> selectByName(String name);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKeyWithBLOBs(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> listAll();
}