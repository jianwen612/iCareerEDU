package com.tosit.genius.dao;

import com.tosit.genius.entity.Apply;
import com.tosit.genius.entity.ApplyKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyMapper {
    int deleteByPrimaryKey(ApplyKey key);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(ApplyKey key);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKeyWithBLOBs(Apply record);

    int updateByPrimaryKey(Apply record);

    int deleteByAdId(String adId);

    List<Apply> listAll();
}