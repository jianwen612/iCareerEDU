package com.tosit.genius.dao;

import com.tosit.genius.entity.Advertisement;
import com.tosit.genius.entity.AdvertisementExample;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdvertisementMapper {
    int deleteByPrimaryKey(String adId);

    int insert(Advertisement record);

    int insertSelective(Advertisement record);

    List<Advertisement> selectByExampleWithBLOBs(AdvertisementExample example);

    List<Advertisement> selectByExample(AdvertisementExample example);

    List<Advertisement> selectByName(String name);


    Advertisement selectByPrimaryKey(String adId);

    int updateByPrimaryKeySelective(Advertisement record);

    int updateByPrimaryKeyWithBLOBs(Advertisement record);

    int updateByPrimaryKey(Advertisement record);

    List<Advertisement> listAll();
}