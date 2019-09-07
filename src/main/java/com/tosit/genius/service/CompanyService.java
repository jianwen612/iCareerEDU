package com.tosit.genius.service;

import com.tosit.genius.entity.Company;

import java.util.List;

public interface CompanyService {
    /**
     * 修改个人信息
     * @param newCompany
     * @return
     */
    int updateByPrimaryKeySelective(Company newCompany);

    /**
     * 企业登录
     * @param record
     * @return
     */
    int login(Company record);

    /**
     * 注册新企业
     * @param record
     * @return
     */
    int register(Company record);

    /**
     * 删除企业
     * @param companyId
     * @return
     */
    int deleteByPrimaryKey(String companyId);

    /**
     * 显示企业列表
     * @return
     */
    List<Company> listAll();


    /**
     * 根据Id搜索企业
     * @param companyId
     * @return
     */
    Company selectByPrimaryKey(String companyId);

    /**
     * 根据name搜索企业
     * @param name
     * @return
     */
    List<Company> selectByName(String name);

    /**
     * 核实企业身份信息
     * @param companyId
     * @param status
     * @return
     */
    int checkCompanyIdentity(String companyId, Boolean status);

}
