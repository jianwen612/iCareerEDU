package com.tosit.genius.dao;

import com.tosit.genius.entity.ConsistKey;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ConsistMapper {
    int deleteByPrimaryKey(ConsistKey key);

    int insert(ConsistKey record);

    int insertSelective(ConsistKey record);

    List<ConsistKey> listAll();
}