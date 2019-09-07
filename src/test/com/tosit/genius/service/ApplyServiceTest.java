
package com.tosit.genius.service;

import com.tosit.genius.entity.ApplyKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})

public class ApplyServiceTest {


    @Autowired
    ApplyService applyService;
    @Test
    public void listAllApplyInfo() throws Exception {
        System.out.println(applyService.listAllApplyInfo("USR0001").get(2).getCompanyName());
    }

    @Test
    public void listApplyInfoIsPassed() throws Exception {
        System.out.println(applyService.listApplyInfoIsPassed("USR0001").get(0).getCompanyName());
    }

    @Test
    public void isApplied() throws Exception {

        System.out.println(applyService.isApplied("USR0001", "ADV0001"));
    }

    @Test
    public void updateIsPassed() throws Exception {
        System.out.println(applyService.updateIsPassed("USR0002", "ADV0005", false));
    }



}
