package com.tosit.genius.service.impl;

import com.tosit.genius.dao.CompanyMapper;
import com.tosit.genius.entity.Company;
import com.tosit.genius.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{

    private CompanyMapper companyMapper;
    Logger logger= LoggerFactory.getLogger(TeacherServiceImpl.class);


    @Autowired
    public CompanyServiceImpl(CompanyMapper companyMapper){
        this.companyMapper = companyMapper;
    }

    @Override
    public int updateByPrimaryKeySelective(Company newCompany) {
        return companyMapper.updateByPrimaryKeySelective(newCompany);
    }

    @Override
    public int login(Company record) {
        Company company1=companyMapper.selectByPrimaryKey(record.getCompanyId());
        try{
            String pswd=company1.getCompanyId();
            if(pswd.equals(company1.getCompanyId())){
                return 1;
            }
            else{
                return 0;
            }

        }catch (Exception e)
        {
            logger.error(e.getMessage());
            return 0;
        }
    }

    @Override
    public int register(Company record) {
        System.out.println("serviceimpl:"+record.getCompanyId());
        if(companyMapper.selectByPrimaryKey(record.getCompanyId())!=null) {
            logger.info("already exits, fail to register:"+record.getCompanyId());
            return 0;
        }
        else {
            try{
                int result=companyMapper.insertSelective(record);
                if (result==1){
                    return 1;
                }
                else{
                    return 0;
                }
            }catch (Exception e){
                logger.error(e.getMessage());
                return 0;
            }
        }
    }

    @Override
    public int deleteByPrimaryKey(String companyId) {
        return companyMapper.deleteByPrimaryKey(companyId);
    }

    @Override
    public List<Company> listAll() {
        return companyMapper.listAll();
    }

    @Override
    public Company selectByPrimaryKey(String companyId) {
        return companyMapper.selectByPrimaryKey(companyId);
    }

    @Override
    public List<Company> selectByName(String name) {
        return companyMapper.selectByName(name);
    }

    @Override
    public int checkCompanyIdentity(String companyId, Boolean status) {
        if(status == false) {
            companyMapper.deleteByPrimaryKey(companyId);
            return 1;
        }
        Company company = new Company();
        company.setCompanyId(companyId);
        company.setCompanyStatus(status);
        return companyMapper.updateByPrimaryKeySelective(company);
    }
}
