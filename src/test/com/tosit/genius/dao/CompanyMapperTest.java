package com.tosit.genius.dao;

import com.tosit.genius.dao.CompanyMapper;
import com.tosit.genius.entity.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@RunWith(SpringRunner.class)
public class CompanyMapperTest {
    @Autowired
    CompanyMapper companyMapper;
    @Test
    public void deleteByPrimaryKey() throws Exception {
        System.out.println(companyMapper.deleteByPrimaryKey("COM0009"));
    }

    @Test
    public void insertSelective() throws Exception {
        Company company = new Company();
        company.setCompanyId("COM0009");
        System.out.println(companyMapper.insertSelective(company));
    }

}