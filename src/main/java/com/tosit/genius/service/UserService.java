package com.tosit.genius.service;

import com.tosit.genius.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserService {

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(String userId);


    /**
     * 注册新用户
     * @param record
     * @return
     */
    int register(User record);

    /**
     * 根据Id搜索用户
     * @param userId
     * @return
     */
    User selectByPrimaryKey(String userId);

    /**
     * 根据name搜索用户
     * @param name
     * @return
     */
    List<User> selectByName(String name);


    /**
     * 修改个人信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);

    /**
     * 显示用户列表
     * @return
     */
    List<User> listAll();

    /**
     * 用户登录
     * @param user
     * @return
     */
    int login(User user);
}
