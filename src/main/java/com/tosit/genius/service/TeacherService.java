package com.tosit.genius.service;

import com.tosit.genius.entity.Teacher;

import java.util.List;

/**
 * 教师业务对象
 */
public interface TeacherService {

    /**
     * 修改个人信息
     * @param newTeacher
     * @return
     */
    int updateByPrimaryKeySelective(Teacher newTeacher);

    /**
     * 教师登录
     * @param record
     * @return
     */
    int login(Teacher record);

    /**
     * 注册新教师
     * @param record
     * @return
     */
    int register(Teacher record);

    /**
     * 删除教师
     * @param teacherId
     * @return
     */
    int deleteByPrimaryKey(String teacherId);

    /**
     * 显示教师列表
     * @return
     */
    List<Teacher> listAll();


    /**
     * 根据Id搜索老师
     * @param teacherId
     * @return
     */
    Teacher selectByPrimaryKey(String teacherId);

    /**
     * 根据name搜索老师
     * @param name
     * @return
     */
    List<Teacher> selectByName(String name);

    /**
     * 核实教师身份信息
     * @param teacherId
     */
    int checkTeacherIdentity(String teacherId, Boolean status);


}
