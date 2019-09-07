package com.tosit.genius.service.impl;

import com.tosit.genius.dao.UserMapper;
import com.tosit.genius.entity.User;
import com.tosit.genius.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public int deleteByPrimaryKey(String userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int register(User record) {
        System.out.println("serviceimpl:"+record.getUserId());
        if(userMapper.selectByPrimaryKey(record.getUserId())!=null)
        {
            logger.info("already exits, fail to register:"+record.getUserId());
            return 0;
        }
        else
        {
            try{
                int result=userMapper.insertSelective(record);
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
    public int login(User user){
        User user1=userMapper.selectByPrimaryKey(user.getUserId());
        try{
            String pswd=user1.getUserPswd();
            if(pswd.equals(user.getUserPswd())){
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
    public User selectByPrimaryKey(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> selectByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {

        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }
}
