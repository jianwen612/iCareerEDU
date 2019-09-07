package com.tosit.genius.service.impl;

import com.tosit.genius.dao.TeacherMapper;
import com.tosit.genius.entity.Teacher;
import com.tosit.genius.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{

    private TeacherMapper teacherMapper;
    Logger logger= LoggerFactory.getLogger(TeacherServiceImpl.class);

    @Autowired
    public TeacherServiceImpl(TeacherMapper teacherMapper){
        this.teacherMapper = teacherMapper;
    }

    @Override
    public int updateByPrimaryKeySelective(Teacher newTeacher) {
        return teacherMapper.updateByPrimaryKeySelective(newTeacher);
    }

    @Override
    public int login(Teacher record) {
        Teacher teacher1=teacherMapper.selectByPrimaryKey(record.getTeacherId());
        try{
            String pswd=teacher1.getTeacherId();
            if(pswd.equals(teacher1.getTeacherId())){
                return 1;
            }
            else{
                return 0;
            }

        }catch (Exception e)
        {
            logger.error(e.getMessage());
            return 0;
        }
    }

    @Override
    public int register(Teacher record) {
        System.out.println("serviceimpl:"+record.getTeacherId());
        if(teacherMapper.selectByPrimaryKey(record.getTeacherId())!=null) {
            logger.info("already exits, fail to register:"+record.getTeacherId());
            return 0;
        }
        else {
            try{
                int result=teacherMapper.insertSelective(record);
                if (result==1){
                    return 1;
                }
                else{
                    return 0;
                }
            }catch (Exception e){
                logger.error(e.getMessage());
                return 0;
            }
        }
    }

    @Override
    public int deleteByPrimaryKey(String teacherId) {
        return teacherMapper.deleteByPrimaryKey(teacherId);
    }

    @Override
    public List<Teacher> listAll() {
        return teacherMapper.listAll();
    }

    @Override
    public Teacher selectByPrimaryKey(String teacherId) {
        return teacherMapper.selectByPrimaryKey(teacherId);
    }

    @Override
    public List<Teacher> selectByName(String name) {
        return teacherMapper.selectByName(name);
    }

    @Override
    public int checkTeacherIdentity(String teacherId, Boolean status) {
        if(status == false) {
            teacherMapper.deleteByPrimaryKey(teacherId);
            return 1;
        }
        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherId);
        teacher.setTeacherStatus(status);
        return teacherMapper.updateByPrimaryKeySelective(teacher);
    }
}
