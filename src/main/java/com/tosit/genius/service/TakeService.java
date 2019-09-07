package com.tosit.genius.service;

import com.tosit.genius.entity.Course;
import com.tosit.genius.entity.User;

import java.util.List;

/**
 * 选课业务对象
 */
public interface TakeService {

    /**
     * 获得上课学生
     * @param courseId
     * @return
     */
    List<User> getAllStudentsByCourseId(String courseId);

    /**
     * 学生选择课程
     * @param courseId
     * @return
     */
    Boolean chooseCourse(String courseId, String userId);

    /**
     * 用户得到课程信息
     * @param userId
     * @return
     */
    List<Course> getCourseByUserId(String userId);

    /**
     * 用户删除所选择课程
     * @param courseId
     * @param userId
     * @return
     */
    Boolean deleteCourse(String courseId, String userId);
}
