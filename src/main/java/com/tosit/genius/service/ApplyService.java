package com.tosit.genius.service;

import com.tosit.genius.entity.Advertisement;
import com.tosit.genius.entity.Apply;
import com.tosit.genius.util.AdvertisementInfo;

import java.util.List;

/**
 * 应聘业务对象
 */
public interface ApplyService {

    /**
     * 添加应聘信息
     * @param apply
     * @return
     */
    Boolean applyNew(Apply apply);

    /**
     * 展示登录用户所有应聘信息
     * @return
     */
    List<AdvertisementInfo> listAllApplyInfo(String userId);


    /**
     * 展示登录用户已通过的应聘信息
     * @param userId
     * @return
     */
    List<AdvertisementInfo> listApplyInfoIsPassed(String userId);

    /**
     * 判断用户是否已经申请过应聘信息
     * @param userId
     * @param adId
     * @return
     */
    int isApplied(String userId, String adId);
    /**
     *
     * @param usrId
     * @param adId
     * @param isPassed
     * @return
     */
    int updateIsPassed(String usrId, String adId, Boolean isPassed);









}
