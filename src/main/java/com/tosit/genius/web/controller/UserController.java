package com.tosit.genius.web.controller;

import com.tosit.genius.dao.UserMapper;
import com.tosit.genius.entity.*;
import com.tosit.genius.service.*;
import com.tosit.genius.util.AdvertisementInfo;
import com.tosit.genius.util.CourseInfo;
import com.tosit.genius.util.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Log logger = LogFactory.getLog(UserController.class);
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
    public UserController(UserService userService,
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

    @RequestMapping (value = "/register.action",method = RequestMethod.POST)
    @ResponseBody
    public int register(User user,HttpSession session){
        if(user==null){
            return 0;
        }


        logger.info("controller-user-register:"+user.getUserId()+user.getUserPswd());
        try{
            int status=userService.register(user)==1?1:0;

            return  status;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }

    }


    @RequestMapping (value = "/login.action")
    @ResponseBody
    public int login(/*@RequestBody*/ User user,  HttpSession session)
    {
        User sessionUser=(User)session.getAttribute("user");
        String userId=user.getUserId();
        System.out.println("try login:"+user);
        System.out.println("tri loginsession:"+sessionUser);
        if(user.getUserId()==null||user.getUserPswd()==null)
        {
            System.out.println("some is null");
            return 0;
        }
        if(sessionUser==null)
        {
            System.out.println("session==null");
            int result=userService.login(user);
            System.out.println("登录失败");
            if(result==1)
            {
                User findUser=userService.selectByPrimaryKey(userId);
                session.setAttribute("user", findUser);
                return 1;
            }
            else{
                return 0;
            }
        }else{

            System.out.println("user reloginUser:"+sessionUser);
            return 1;
        }
    }

    @RequestMapping (value = "/logout.action",method = RequestMethod.POST)
    @ResponseBody
    public  String login(HttpSession session){
        System.out.println("controller-user-logout:");
        session.invalidate();
        return "1";
    }

    @RequestMapping (value = "/listAll.action",method = RequestMethod.GET)
    @ResponseBody
    public  Response<List<User>> listAll(){
        logger.info("controller-user-listAll");
        Response<List<User>> response=new Response<List<User>>();
        List<User> list=userService.listAll();

        if (list==null)
        {
            response.status=0;
        }
        else{
            response.status=1;
            response.data=list;
        }

        return response;

    }

    @RequestMapping (value = "/getInfo.action",method = RequestMethod.GET)
    @ResponseBody
    public Response<User> getInfo(HttpSession session){
        System.out.println("getting info");
        Response<User> response=new Response<User>();
        User user=(User)session.getAttribute("user");

        if(user==null)
        {
            System.out.println("no info");
            response.status=0;

        }
        else{
            User newInfo=userService.selectByPrimaryKey(user.getUserId());
            response.data=newInfo;
            session.setAttribute("user",newInfo);
            response.status=1;
        }
        return response;
    }

    @RequestMapping (value = "/getCourseInfo.action",method = RequestMethod.GET)
    @ResponseBody
    public Response<CourseInfo> getCourseInfo(HttpSession session,String courseId){
        System.out.println("getting CourseInfo");
        Response<CourseInfo> response=new Response<>();

        try{

            Course course=courseService.selectById(courseId);

            Teacher teacher=teacherService.selectByPrimaryKey(course.getCourseTeacherId());
            Subject subject=subjectService.searchById(course.getCourseSubjectId());

            CourseInfo courseInfo=new CourseInfo();

            courseInfo.setCourseEndDate(course.getCourseEndDate());
            courseInfo.setCourseId(course.getCourseId());
            courseInfo.setCourseIntroduction(course.getCourseIntroduction());
            courseInfo.setCourseName(course.getCourseName());
            courseInfo.setCourseRegDate(course.getCourseRegDate());
            courseInfo.setCourseStartDate(course.getCourseStartDate());
            courseInfo.setCourseSubjectId(course.getCourseSubjectId());
            courseInfo.setCourseTeacherId(course.getCourseTeacherId());
            courseInfo.setCourseTimes(course.getCourseTimes());

            courseInfo.setSubjectName(subject.getSubjectName());
            courseInfo.setTeacherEmail(teacher.getTeacherEmail());
            courseInfo.setTeacherIntroduction(teacher.getTeacherIntroduction());
            courseInfo.setTeacherName(teacher.getTeacherName());
            courseInfo.setTeacherUniversity(teacher.getTeacherUniversity());

            response.status=1;
            response.data=courseInfo;
            return  response;
        }catch (Exception e){
            response.status=0;
            return response;
        }

    }

    @RequestMapping (value = "/searchCourse.action",method = RequestMethod.POST)
    @ResponseBody
    public List<Course> searchCourse(String courseName,HttpSession session) {
//        String lastSearch=(String)session.getAttribute("searchString");
//        if(lastSearch==null){
//
//            return  courseService.selectByName("");
//        }else{
//
//            session.removeAttribute("searchString");
//            return courseService.selectByName()
//        }
//
//
        return courseService.selectByName(courseName);
    }

    @RequestMapping (value = "/getAd.action",method = RequestMethod.GET)
    @ResponseBody
    public List<AdvertisementInfo> getAd(HttpSession session) {

        System.out.println("get all Advertisement:");


        List<AdvertisementInfo> advertisementInfoList=new ArrayList<>();
        List<Advertisement> advertisementList;
//        Response<List<AdvertisementInfo>> response=new Response<>();

        advertisementList=advertisementService.getAllAd();

            for(int i=0;i<advertisementList.size();i++){
                Advertisement advertisement=advertisementList.get(i);


                Company company=companyService.selectByPrimaryKey(advertisement.getAdCompanyId());
                if(company==null){
                    continue;
                }

                AdvertisementInfo advertisementInfo=new AdvertisementInfo();

                advertisementInfo.setAdId(advertisement.getAdId());
                advertisementInfo.setAdStatus(advertisement.getAdStatus());
                advertisementInfo.setAdCompanyId(advertisement.getAdCompanyId());
                advertisementInfo.setAdTitle(advertisement.getAdTitle());
                advertisementInfo.setAdContent(advertisement.getAdContent());


                advertisementInfo.setCompanyEmail(company.getCompanyEmail());
                advertisementInfo.setCompanyIntroduction(company.getCompanyIntroduction());
                advertisementInfo.setCompanyName(company.getCompanyName());
                advertisementInfo.setCompanyPhoneNo(company.getCompanyPhoneNo());



                advertisementInfoList.add(advertisementInfo);


        }
//        response.status=1;


//        response.data=advertisementInfoList;

        return advertisementInfoList;

    }


    @RequestMapping (value = "/getMyPass.action",method = RequestMethod.GET)
    @ResponseBody
    public List<AdvertisementInfo> getMyPass(HttpSession session) {



        User user=(User)session.getAttribute("user");


        if(user==null){
            System.out.println("未登录");
            return  null;
        }

        String  userId=user.getUserId();

        System.out.println("get all passed Advertisement:"+user.getUserId());

        List<AdvertisementInfo> advertisementInfoList;

        advertisementInfoList=applyService.listApplyInfoIsPassed(userId);

        return advertisementInfoList;

    }

    @RequestMapping (value = "/getMyApply.action",method = RequestMethod.GET)
    @ResponseBody
    public List<AdvertisementInfo> getMyApply(HttpSession session) {



        User user=(User)session.getAttribute("user");


        if(user==null){
            System.out.println("未登录");
            return  null;
        }

        String  userId=user.getUserId();

        System.out.println("get all passed Advertisement:"+user.getUserId());

        List<AdvertisementInfo> advertisementInfoList;

        advertisementInfoList=applyService.listAllApplyInfo(userId);

        return advertisementInfoList;

    }


    @RequestMapping(value = "/addCourse.action")
    @ResponseBody
    public int addCourse(HttpSession session, String courseId) {
        System.out.println("addCourse:"+courseId);
        User user=(User) session.getAttribute("user");
        String userId=user.getUserId();
        if(user==null){
            return 0;
        }
        boolean result=takeService.chooseCourse(courseId,userId);
        if(result==true)
        {
            return 1;
        }else{
            return 0;
        }


    }

    @RequestMapping(value = "/apply.action",method = RequestMethod.POST)
    @ResponseBody
    public int apply(HttpSession session, String adId,String statement) {
        System.out.println("apply:"+adId);
        User user=(User) session.getAttribute("user");
        if(user==null){
            return 0;
        }
        String userId=user.getUserId();
        Apply apply=new Apply();
        apply.setApplyAdId(adId);
        apply.setApplyUserId(userId);
        apply.setApplyDate(new Date());
        apply.setStatement(statement);
        apply.setIspassed(false);

        try{
            boolean result=applyService.applyNew(apply);

            if(result==true)
            {
                return 1;
            }else{
                return 0;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;

        }




    }

    @RequestMapping(value = "/checkApply.action",method = RequestMethod.POST)
    @ResponseBody
    public int checkApply(HttpSession session, String adId) {
        System.out.println("checkApply:"+adId);
        User user=(User) session.getAttribute("user");
        if(user==null){
            return 0;
        }
        String userId=user.getUserId();


        try{
            int result=applyService.isApplied(userId,adId);

            return result==1?1:0;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;

        }




    }

    @RequestMapping(value = "/modifyPswd.action", method = RequestMethod.POST)
    @ResponseBody
    public int modifyPswd(String oldPswd,String userPswd, HttpSession session
    ) {


        User user1 = (User) session.getAttribute("user");

        if (user1 == null) {
            return 0;
        }

        user1=userService.selectByPrimaryKey(user1.getUserId());
        String correctPswd=user1.getUserPswd();
        if(!correctPswd.equals(oldPswd)){
            return 0;
        }

        user1.setUserPswd(userPswd);

        System.out.println("try modify old pswd:" + oldPswd);


        int result = userService.updateByPrimaryKeySelective(user1);
        System.out.println("pswd:" + user1.getUserPswd());
        return result == 1 ? 1 : 0;
    }

    @RequestMapping(value = "/deleteCourse.action")
    @ResponseBody
    public int deleteCourse(HttpSession session, String courseId) {
        System.out.println("deleteCourse:"+courseId);
        User user=(User) session.getAttribute("user");
        if(user==null){
            return 0;
        }

        String userId=user.getUserId();
        boolean result=takeService.deleteCourse(courseId,userId);
        if(result==true)
        {
            return 1;
        }else{
            return 0;
        }


    }



    @RequestMapping(value = "myCourse.action")
    @ResponseBody
    public List<CourseInfo> myCourse(HttpSession session) {
        System.out.println("get my course:");


        User user=(User) session.getAttribute("user");

        String userId=user.getUserId();
        List<CourseInfo> courseInfoList=new ArrayList<>();
        List<Course> courseList;
        Response<List<CourseInfo>> response=new Response<>();
        if(user==null){
            response.status=0;

        }else{
            courseList=takeService.getCourseByUserId(userId);
            int len=courseList.size();
            System.out.println("courseAmount:"+len);
            for(int i=0;i<len;i++){

                Course course=courseList.get(i);
                String teacherId=course.getCourseTeacherId();
                System.out.println("teacherId:"+teacherId);
                Teacher teacher=teacherService.selectByPrimaryKey(teacherId);

                Subject subject=subjectService.searchById(course.getCourseSubjectId());

                CourseInfo courseInfo=new CourseInfo();

                courseInfo.setCourseEndDate(course.getCourseEndDate());
                courseInfo.setCourseId(course.getCourseId());
                courseInfo.setCourseIntroduction(course.getCourseIntroduction());
                courseInfo.setCourseName(course.getCourseName());
                courseInfo.setCourseRegDate(course.getCourseRegDate());
                courseInfo.setCourseStartDate(course.getCourseStartDate());
                courseInfo.setCourseSubjectId(course.getCourseSubjectId());
                courseInfo.setCourseTeacherId(course.getCourseTeacherId());
                courseInfo.setCourseTimes(course.getCourseTimes());

                courseInfo.setSubjectName(subject.getSubjectName());
                courseInfo.setTeacherEmail(teacher.getTeacherEmail());
                courseInfo.setTeacherIntroduction(teacher.getTeacherIntroduction());
                courseInfo.setTeacherName(teacher.getTeacherName());
                courseInfo.setTeacherUniversity(teacher.getTeacherUniversity());

                courseInfoList.add(courseInfo);
//                response.status=1;
            }
        }


//        response.data=courseInfoList;

        return courseInfoList;
    }


    @RequestMapping (value = "editInfo.action",method = RequestMethod.POST)
    @ResponseBody
    public int saveInformation(User user,HttpSession session
    ){
        User user1=(User)session.getAttribute("user");
        if(user1==null){
            return 0;
        }

        String userId=user1.getUserId();
        user.setUserId(userId);

        int result=userService.updateByPrimaryKeySelective(user);
        System.out.println("editInfo:"+user.getUserName()+"userId:"+userId);
        return result==1?1:0;

    }


    @RequestMapping (value = "/videoList.action",method = RequestMethod.POST)
    @ResponseBody
    public List<Video> VideoList(String courseId,HttpSession session) {
        System.out.println("get video list:"+courseId);
        if(courseId==null){
            System.out.println("课程号为空");
            return null;
        }
//
//
        return videoService.getVideoByCourse(courseId);
    }


    @RequestMapping (value = "/videoInfo.action",method = RequestMethod.POST)
    @ResponseBody
    public Video VideoInfo(String videoId,HttpSession session) {
        System.out.println("get video info:"+videoId);
        if(videoId==null){
            System.out.println("课程号为空");
            return null;
        }
//
//
        return videoService.selectByVideoId(videoId);
    }



}
