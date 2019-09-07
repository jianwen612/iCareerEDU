package com.tosit.genius.service.impl;

import com.tosit.genius.dao.CourseMapper;
import com.tosit.genius.dao.TakeMapper;
import com.tosit.genius.dao.UserMapper;
import com.tosit.genius.entity.Course;
import com.tosit.genius.entity.TakeKey;
import com.tosit.genius.entity.User;
import com.tosit.genius.service.TakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("takeService")
public class TakeServiceImpl implements TakeService {

    private TakeMapper takeMapper;
    private UserMapper userMapper;
    private CourseMapper courseMapper;

    @Autowired

    public TakeServiceImpl(TakeMapper takeMapper, UserMapper userMapper, CourseMapper courseMapper){

        this.takeMapper = takeMapper;
        this.userMapper = userMapper;
        this.courseMapper = courseMapper;
    }

    @Override
    public List<User> getAllStudentsByCourseId(String courseId) {

        List<TakeKey> takeKeys = takeMapper.selectUserIdByCourseId(courseId);

        List<User> userList = new ArrayList<>();

        for(int i = 0; i < takeKeys.size(); i++){
            userList.add(userMapper.selectByPrimaryKey(takeKeys.get(i).getTakeUserId()));
        }

        return userList;

    }

    @Override
    public Boolean chooseCourse(String courseId, String userId) {

        TakeKey takeKey = new TakeKey();
        takeKey.setTakeCourseId(courseId);
        takeKey.setTakeUserId(userId);





        List<TakeKey> takeKeyList = takeMapper.selectCourseIdByUserId(userId);

        if(takeKeyList.size()!=0)
        {
            for(int i = 0; i < takeKeyList.size(); i++){
                if(takeKeyList.get(i).getTakeCourseId().equals(courseId)){
                    return false;
                }
            }

        }

        int flag = takeMapper.insertSelective(takeKey);
        if(flag == 0)
            return false;
        else
            return true;
    }

    @Override
    public List<Course> getCourseByUserId(String userId) {
        List<TakeKey> takeKeyList = takeMapper.listAll();
        List<String> courseIdList = new ArrayList<>();
        for(int i = 0; i < takeKeyList.size(); i++){
            if(takeKeyList.get(i).getTakeUserId().equals(userId))
                courseIdList.add(takeKeyList.get(i).getTakeCourseId());
        }
        List<Course> courseList = new ArrayList<>();
        for(int j = 0; j < courseIdList.size(); j++){
            courseList.add(courseMapper.selectByPrimaryKey(courseIdList.get(j)));
        }
        return courseList;
    }

    @Override
    public Boolean deleteCourse(String courseId, String userId) {
        TakeKey takeKey = new TakeKey();
        takeKey.setTakeCourseId(courseId);
        takeKey.setTakeUserId(userId);
        int flag = takeMapper.deleteByPrimaryKey(takeKey);
        if(flag == 0)
            return false;
        return true;
    }


}