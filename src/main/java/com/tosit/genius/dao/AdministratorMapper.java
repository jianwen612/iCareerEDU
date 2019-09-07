package com.tosit.genius.dao;

import com.tosit.genius.entity.Administrator;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdministratorMapper {
    int deleteByPrimaryKey(String adminId);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(String adminId);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);

    List<Administrator> listAll();
}