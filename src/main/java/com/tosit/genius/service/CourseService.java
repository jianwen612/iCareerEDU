package com.tosit.genius.service;

import com.tosit.genius.entity.Course;
import com.tosit.genius.entity.Subject;
import com.tosit.genius.entity.Teacher;
import com.tosit.genius.entity.User;

import java.util.List;

/**
 * 课程业务对象
 */

public interface CourseService {

    /**
     * 教师根据教师ID获取课程列表
     * @param teacherId
     * @return
     */
    List<Course> getCourseByTeacherId(String teacherId);

    /**
     * 教师申请新课程
     * @param course
     * @return
     */
    Boolean addNewCourse(Course course);

    /**
     * 教师删除旧课程
     * @param courseId
     * @return
     */
    Boolean deleteCourse(String courseId);

    /**
     * 教师修改课程
     * @param newCourse
     * @return
     */
    Boolean updateCourse(Course newCourse);

    /**
     * 搜索课程
     * @param name
     * @return
     */
    List<Course> selectByName(String name);

    /**
     * 根据Id获得课程
     * @param id
     * @return
     */
    Course selectById(String id);


}
