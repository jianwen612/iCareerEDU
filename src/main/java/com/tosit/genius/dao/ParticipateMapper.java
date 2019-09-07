package com.tosit.genius.dao;

import com.tosit.genius.entity.Participate;
import com.tosit.genius.entity.ParticipateKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipateMapper {
    int deleteByPrimaryKey(ParticipateKey key);

    int insert(Participate record);

    int insertSelective(Participate record);

    Participate selectByPrimaryKey(ParticipateKey key);

    int updateByPrimaryKeySelective(Participate record);

    int updateByPrimaryKey(Participate record);

    List<Participate> listAll();
}