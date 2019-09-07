package com.tosit.genius.dao;

import com.tosit.genius.entity.Receive;
import com.tosit.genius.entity.ReceiveKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiveMapper {
    int deleteByPrimaryKey(ReceiveKey key);

    int insert(Receive record);

    int insertSelective(Receive record);

    Receive selectByPrimaryKey(ReceiveKey key);

    int updateByPrimaryKeySelective(Receive record);

    int updateByPrimaryKey(Receive record);

    List<Receive> listAll();
}