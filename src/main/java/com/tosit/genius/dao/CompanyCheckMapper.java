package com.tosit.genius.dao;

import com.tosit.genius.entity.CompanyCheck;
import com.tosit.genius.entity.CompanyCheckKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyCheckMapper {
    int deleteByPrimaryKey(CompanyCheckKey key);

    int insert(CompanyCheck record);

    int insertSelective(CompanyCheck record);

    CompanyCheck selectByPrimaryKey(CompanyCheckKey key);

    int updateByPrimaryKeySelective(CompanyCheck record);

    int updateByPrimaryKey(CompanyCheck record);

    List<CompanyCheck> listAll();
}