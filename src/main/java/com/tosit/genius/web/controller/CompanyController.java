package com.tosit.genius.web.controller;

import com.tosit.genius.entity.*;
import com.tosit.genius.service.*;
import com.tosit.genius.util.ApplyInfo;
import com.tosit.genius.util.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 企业模块controller
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
    private static final Log logger = LogFactory.getLog(CompanyController.class);
    private UserService userService;
    private CourseService courseService;
    private AdvertisementService advertisementService;
    private ApplyService applyService;
    private TakeService takeService;
    private TeacherService teacherService;
    private SubjectService subjectService;
    private CompanyService companyService;
    private VideoService videoService;


    @Autowired
    public CompanyController(UserService userService,
                          TakeService takeService,
                          ApplyService applyService,
                          AdvertisementService advertisementService,
                          CourseService courseService,
                          TeacherService teacherService,
                          SubjectService subjectService,
                          CompanyService companyService,
                          VideoService videoService){

        this.userService=userService;
        this.takeService=takeService;
        this.courseService=courseService;
        this.advertisementService=advertisementService;
        this.applyService=applyService;
        this.subjectService=subjectService;
        this.teacherService=teacherService;
        this.companyService=companyService;
        this.videoService=videoService;
    }

    /**
     * 企业注册
     * @param company
     * @param session
     * @return
     */
    @RequestMapping (value = "/register.action",method = RequestMethod.POST)
    @ResponseBody
    public int register(Company company,HttpSession session){
        if(company==null){
            return 0;
        }


        logger.info("controller-company-register:"+company.getCompanyId()+company.getCompanyPswd());
        try{
            int status=companyService.register(company)==1?1:0;
            return status;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }


    }

    /**
     * 企业登录接口
     * @param company
     * @param session 会话信息
     * @return
     */
    @RequestMapping(value = "/login.action")
    @ResponseBody
    public int login(/*@RequestBody*/ Company company, HttpSession session) {
        Company sessionCompany = (Company) session.getAttribute("company");
        String companyId = company.getCompanyId();
        System.out.println("try login:" + company);
        System.out.println("tri loginsession:" + sessionCompany);
        if (company.getCompanyId() == null || company.getCompanyPswd() == null) {
            System.out.println("some is null");
            return 0;
        }
        if (sessionCompany == null) {
            System.out.println("session==null");
            int result = companyService.login(company);

            if (result == 1) {
                Company findCompany = companyService.selectByPrimaryKey(companyId);
                session.setAttribute("company", findCompany);
                return 1;
            } else {
                System.out.println("登录失败");
                return 0;
            }
        } else {

            System.out.println("company reloginCompany:" + sessionCompany);
            return 1;
        }
    }

    /**
     * 用户退出 清楚会话信息
     *
     * @param session 会话信息
     * @return 登陆界面
     */
    @RequestMapping(value = "/logout.action", method = RequestMethod.POST)
    @ResponseBody
    public String logout(HttpSession session) {
        System.out.println("controller-company-logout:");
        session.invalidate();
        return "1";
    }


    /**
     * 根据session获取企业信息
     *
     * @param session
     * @return 企业信息
     */
    @RequestMapping(value = "/getInformation.action", method = RequestMethod.GET)
    @ResponseBody
    public Response<Company> getInformation(HttpSession session) {
        System.out.println("getting info");

        Response<Company> response = new Response<Company>();
        Company company = (Company) session.getAttribute("company");

        if (company == null) {
            System.out.println("no info");
            response.status = 0;

        } else {
            Company newInfo = companyService.selectByPrimaryKey(company.getCompanyId());
            response.data = newInfo;
            session.setAttribute("company", newInfo);
            response.status = 1;
        }
        return response;
    }

    /**保存企业信息
     * @param company
     * @param session
     * @return
     */
    @RequestMapping(value = "/saveInformation.action", method = RequestMethod.POST)
    @ResponseBody
    public int saveInformation(Company company, HttpSession session
    ) {
        Company company1 = (Company) session.getAttribute("company");
        if (company1 == null) {
            return 0;
        }

        String companyId = company1.getCompanyId();
        company.setCompanyId(companyId);

        int result = companyService.updateByPrimaryKeySelective(company);
        System.out.println(company.getCompanyName());
        return result == 1 ? 1 : 0;

    }

    /**修改密码
     * @param company
     * @param session
     * @return
     */

    @RequestMapping(value = "/modifyPswd.action", method = RequestMethod.POST)
    @ResponseBody
    public int modifyPswd(Company company, HttpSession session
    ) {
        Company company1 = (Company) session.getAttribute("company");
        if (company1 == null) {
            return 0;
        }
        String companyId = company1.getCompanyId();//user id
        company.setCompanyId(companyId);// input id
        System.out.println("try modify pswd:" + companyId);

        int result = companyService.updateByPrimaryKeySelective(company);
        System.out.println("pswd:" + company.getCompanyPswd());
        return result == 1 ? 1 : 0;
    }

    /**获取该企业发布的招聘信息
     * @param session
     * @return
     */
    @RequestMapping(value = "getCompanyAdvertisement.action", method = RequestMethod.GET)
    @ResponseBody
    public List<Advertisement> getCompanyAdvertisement(HttpSession session) {

        Company company1 = (Company) session.getAttribute("company");
        if (company1 == null) {
            return null;
        }

        String companyId = company1.getCompanyId();//user id
        System.out.println("try get ad:" + companyId);
        List<Advertisement> advertisementList;
        advertisementList = advertisementService.getAdByCompanyId(companyId);
        return advertisementList;
    }

    /**删除该企业的招聘信息
     * @param session
     * @param adId
     * @return
     */
    @RequestMapping(value = "/deleteAdvertisement.action", method = RequestMethod.POST)
    @ResponseBody
    public int deleteAdvertisement(HttpSession session, String adId) {
        System.out.println("deleteAdvertisement:" + adId);
        Company company = (Company) session.getAttribute("company");
        if (company == null) {
            return 0;
        }
        boolean result = advertisementService.deleteAd(adId);
        System.out.println("000000000000" + result);
        if (result == true) {
            return 1;
        } else {
            return 0;
        }


    }

    /**
     * 获取招聘信息
     * @param session
     * @param adId
     * @return
     */
    @RequestMapping(value = "/getAd.action", method = RequestMethod.GET)
    @ResponseBody
    public Response<Advertisement> getAd(HttpSession session, String adId) {
        System.out.println("getting info" + adId);
        Response<Advertisement> response = new Response<Advertisement>();
        Company company = (Company) session.getAttribute("company");
        if (company == null) {
            System.out.println("no info");
            response.status = 0;

        } else {
            Advertisement newInfo = advertisementService.selectByPrimaryKey(adId);
            response.data = newInfo;
            session.setAttribute("ad", newInfo);
            response.status = 1;
        }
        return response;
    }

    /**
     * 保存招聘信息
     * @param advertisement
     * @param session
     * @param adId
     * @return
     */
    @RequestMapping(value = "/saveAd.action", method = RequestMethod.POST)
    @ResponseBody
    public int saveAd(Advertisement advertisement, HttpSession session, String adId) {
        Company company1 = (Company) session.getAttribute("company");
        if (company1 == null) {
            return 0;
        }
        boolean result = advertisementService.updateAd(advertisement);
        System.out.println(adId);
        return result == true ? 1 : 0;

    }

    /**
     * 发布招聘信息
     * @param adTitle
     * @param adContent
     * @param session
     * @return
     */
    @RequestMapping(value = "/addAd.action", method = RequestMethod.POST)
    @ResponseBody
    public int addVideo(@RequestParam("adTitle") String adTitle, @RequestParam("adContent") String adContent, HttpSession session) {
        Company company1 = (Company) session.getAttribute("company");
        if (company1 == null) {
            return 0;
        }
        long t = System.currentTimeMillis();
        java.util.Random rd=new java.util.Random(t);
        System.out.println("enter!!!");
        Advertisement advertisement = new Advertisement();
        advertisement.setAdTitle(adTitle);
        advertisement.setAdContent(adContent);
        advertisement.setAdCompanyId(company1.getCompanyId());
        advertisement.setAdId(company1.getCompanyId() +"-"+ rd.nextInt());
        System.out.println(rd);
        return advertisementService.insertNewAd(advertisement) == true ? 1 : 0;

    }

    /**
     * 获取应聘申请
     * @param session
     * @return
     */
    @RequestMapping(value = "getAdApply.action",method = RequestMethod.GET)
    @ResponseBody
    public List<ApplyInfo> getAdApply(HttpSession session) {
        System.out.println("get my getAdApply:");
        Company company = (Company) session.getAttribute("company");
        if (company == null) {
            return null;

        }
        String companyId = company.getCompanyId();
        List<ApplyInfo> applyInfoList = new ArrayList<>();
        List<Apply> applyList = advertisementService.getAppliedUser(companyId);

        int len=applyList.size();

        System.out.println(len);
        for (int i = 0; i < len; i++) {
            Apply apply = applyList.get(i);
            User user = userService.selectByPrimaryKey(apply.getApplyUserId());
            if(user==null){
                continue;
            }
            Advertisement advertisement = advertisementService.selectByPrimaryKey(apply.getApplyAdId());
            ApplyInfo applyIfo = new ApplyInfo();
            applyIfo.setApplyUserId(apply.getApplyUserId());
            applyIfo.setUserName(user.getUserName());
            applyIfo.setAdTitle(advertisement.getAdTitle());
            applyIfo.setAdContent(advertisement.getAdContent());
            applyIfo.setUserEmail(user.getUserEmail());
            applyIfo.setApplyDate(apply.getApplyDate());
            applyIfo.setIspassed(apply.getIspassed());
            applyIfo.setStatement(apply.getStatement());
            applyIfo.setApplyAdId(apply.getApplyAdId());
            applyInfoList.add(applyIfo);
        }
        return applyInfoList;
    }

    /**
     * 审核应聘
     * @param applyUserId
     * @param applyAdId
     * @param session
     * @return
     */
    @RequestMapping(value = "/passApply.action",method = RequestMethod.POST)
    @ResponseBody
    public int passApply( String applyUserId,String applyAdId,HttpSession session) {
        System.out.println("applyAD:" + applyAdId);
        System.out.println("applyUS" + applyUserId);
        Company company = (Company) session.getAttribute("company");
        if (company == null) {
            return 0;
        }
        String companyId = company.getCompanyId();
        Apply apply = new Apply();
        apply.setIspassed(true);
        try {
            int result = applyService.updateIsPassed(applyUserId,applyAdId,apply.getIspassed());

            if (result == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;

        }
    }



}