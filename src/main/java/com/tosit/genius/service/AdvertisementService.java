package com.tosit.genius.service;

import com.tosit.genius.entity.Advertisement;
import com.tosit.genius.entity.Apply;
import com.tosit.genius.entity.Company;

import java.util.List;

/**
 * 招聘信息业务对象
 */
public interface AdvertisementService {

    /**
     * 发布招聘信息
     * @param advertisement
     * @return
     */
    Boolean insertNewAd(Advertisement advertisement);

    /**
     * 删除招聘信息
     * @param adId
     * @return
     */
    Boolean deleteAd(String adId);

    /**
     * 修改招聘信息
     * @param newAd
     * @return
     */
    Boolean updateAd(Advertisement newAd);

    /**
     * 获得全部的招聘信息
     * @return
     */
    List<Advertisement> getAllAd();

    /**
     * 搜索应聘信息
     * @param name
     * @return
     */
    List<Advertisement> getAdByName(String name);

    /**
     * 显示公司发布的招聘信息
     * @param companyId
     * @return
     */
    List<Advertisement> getAdByCompanyId(String companyId);

    /**
     * 核实招聘信息
     * @param adId
     * @param status
     * @return
     */
    int checkAdIdentity(String adId, Boolean status);

    /**
     * 根据招聘信息的企业编号获得企业信息
     * @param companyId
     * @return
     */
    Company getCompanyByComId(String companyId);

    /**
     * 根据公司ID获得已申请用户列表
     * @param companyId
     * @return
     */
    List<Apply> getAppliedUser(String companyId);

    /**
     *通过ID选出招聘信息
     * @param adId
     * @return Advertisement
     */
    Advertisement selectByPrimaryKey(String adId);


}
