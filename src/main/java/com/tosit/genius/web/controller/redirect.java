package com.tosit.genius.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class redirect {
    @RequestMapping("/teacher")
    public String teacherIndex(){

        return "/teacher/teacherIndex.html";
    }

    @RequestMapping("/user")
    public String userIndex(){

        return "/user/userIndex.html";
    }

    @RequestMapping("/company")
    public String companyIndex(){

        return "/company/companyIndex.html";
    }


}
