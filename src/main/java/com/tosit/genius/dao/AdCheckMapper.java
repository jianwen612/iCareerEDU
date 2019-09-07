package com.tosit.genius.dao;

import com.tosit.genius.entity.AdCheck;
import com.tosit.genius.entity.AdCheckKey;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdCheckMapper {
    int deleteByPrimaryKey(AdCheckKey key);

    int insert(AdCheck record);

    int insertSelective(AdCheck record);

    AdCheck selectByPrimaryKey(AdCheckKey key);

    int updateByPrimaryKeySelective(AdCheck record);

    int updateByPrimaryKey(AdCheck record);

    List<AdCheck> listAll();
}