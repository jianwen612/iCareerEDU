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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
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
    public TeacherController(UserService userService,
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




    @RequestMapping (value = "/login.action")
    @ResponseBody
    public int login(/*@RequestBody*/ Teacher teacher,  HttpSession session)
    {
        Teacher sessionTeacher=(Teacher)session.getAttribute("teacher");
        String teacherId=teacher.getTeacherId();
        System.out.println("try login:"+teacher.toString());
        System.out.println("tri loginsession:"+sessionTeacher);
        if(teacher.getTeacherId()==null||teacher.getTeacherPswd()==null)
        {
            System.out.println("some is null");
            return 0;
        }
        if(sessionTeacher==null)
        {
            System.out.println("session==null");
            int result=teacherService.login(teacher);
            System.out.println("登录失败");
            if(result==1)
            {
                Teacher findTeacher=teacherService.selectByPrimaryKey(teacherId);
                session.setAttribute("teacher", findTeacher);
                return 1;
            }
            else{
                return 0;
            }
        }else{

            System.out.println("teacher reloginTeacher:"+sessionTeacher);
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

    @RequestMapping(value = "myCourse.action")
    @ResponseBody
    public List<CourseInfo> myCourse(HttpSession session) {
        System.out.println("teacher get my course:");


        Teacher teacher=(Teacher) session.getAttribute("teacher");

        String teacherId=teacher.getTeacherId();
        List<CourseInfo> courseInfoList=new ArrayList<>();
        List<Course> courseList;
//        Response<List<CourseInfo>> response=new Response<>();
        if(teacher==null){
            return null;

        }else{
            courseList=courseService.getCourseByTeacherId(teacherId);
            int len=courseList.size();
            System.out.println("courseAmount:"+len);
            for(int i=0;i<len;i++){

                Course course=courseList.get(i);

//                String teacherId=teacher.getTeacherId();
                System.out.println("teacherId:"+teacherId);
//                Teacher teacher=teacherService.selectByPrimaryKey(teacherId);

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


    @RequestMapping(value = "/deleteCourse.action")
    @ResponseBody
    public int deleteCourse(HttpSession session, String courseId) {

        System.out.println("deleteCourse:"+courseId);
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        if(teacher==null){
            return 0;
        }


        boolean result=courseService.deleteCourse(courseId);
        if(result==true)
        {
            return 1;
        }else{
            return 0;
        }


    }


    @RequestMapping(value = "getSubjectList.action")
    @ResponseBody
    public List<Subject> subjectList(HttpSession session) {
        System.out.println("teacher get subject:");
        List<Subject> subjectList=subjectService.listAllSubjects();


        return subjectList ;
    }


    @RequestMapping (value = "editCourse.action",method = RequestMethod.POST)
    @ResponseBody
    public int editCourse(Course course,HttpSession session){
        Teacher teacher=(Teacher)session.getAttribute("teacher");
        if(teacher==null){
            return 0;
        }

        if(course==null){
            return 0;
        }


        try{
            course.setCourseTeacherId(teacher.getTeacherId());
            boolean result=courseService.updateCourse(course);


            System.out.println("editCourse:"+course.getCourseName()+course.getCourseIntroduction());
            return result==true?1:0;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return  0;
        }


    }

    @RequestMapping(value = "/addVideo.action")
    @ResponseBody
    public int addVideo(HttpSession session, Video video) {
        if(video==null){
            return 0;
        }

        System.out.println("addVideo:"+video.getVideoName());
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        if(teacher==null){
            return 0;
        }

        long t = System.currentTimeMillis();
        Random rd = new Random(t);
        video.setVideoId(video.getVideoCourseId()+rd.nextInt());
        video.setVideoUploadDate(new Date());



        boolean result=videoService.uploadVideo(video);
        if(result==true)
        {
            return 1;
        }else{
            return 0;
        }


    }

    @RequestMapping(value = "/deleteVideo.action")
    @ResponseBody
    public int deleteVideo(HttpSession session, String videoId) {
        System.out.println("deleteVideo:"+videoId);
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        if(teacher==null){
            return 0;
        }


        boolean result=videoService.deleteVideo(videoId);
        if(result==true)
        {
            return 1;
        }else{
            return 0;
        }


    }

    @RequestMapping(value = "/addCourse.action",method = RequestMethod.POST)
    @ResponseBody
    public int addCourse(  @RequestParam("courseSubjectId") String courseSubjectId,
                           @RequestParam("courseName") String courseName,
                           @RequestParam("courseIntroduction") String courseIntroduction,
                           @RequestParam("courseStartDate") String courseStartDate,
                           @RequestParam("courseEndDate") String courseEndDate,
                           HttpSession session) {
       Course course=new Course();
       Teacher teacher=(Teacher)session.getAttribute("teacher");
       if(teacher==null){
           return 0;
       }



        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date=sdf.parse(courseStartDate);
            course.setCourseStartDate(date);

            date=sdf.parse(courseEndDate);
            course.setCourseEndDate(date);

            course.setCourseRegDate(new Date());

            course.setCourseTeacherId(teacher.getTeacherId());

            course.setCourseSubjectId(courseSubjectId);


            long t = System.currentTimeMillis();
            Random rd = new Random(t);
            course.setCourseId(teacher.getTeacherId()+rd.nextInt());

            course.setCourseIntroduction(courseIntroduction);
            course.setCourseName(courseName);

            System.out.println("addcourse:"+course.toString());

            return courseService.addNewCourse(course)==true?1:0;
        } catch (Exception e) {
            e.printStackTrace();return 0;
        }






    }


    @RequestMapping(value = "/modifyPswd.action", method = RequestMethod.POST)
    @ResponseBody
    public int modifyPswd(String oldPswd,String teacherPswd, HttpSession session
    ) {


        Teacher teacher1 = (Teacher) session.getAttribute("teacher");

        if (teacher1 == null) {
            return 0;
        }

        teacher1=teacherService.selectByPrimaryKey(teacher1.getTeacherId());
        String correctPswd=teacher1.getTeacherPswd();
        if(!correctPswd.equals(oldPswd)){
            return 0;
        }

        teacher1.setTeacherPswd(teacherPswd);

        System.out.println("try modify old pswd:" + oldPswd);


        int result = teacherService.updateByPrimaryKeySelective(teacher1);
        System.out.println("pswd:" + teacher1.getTeacherPswd());
        return result == 1 ? 1 : 0;
    }


    @RequestMapping (value = "/getInfo.action",method = RequestMethod.GET)
    @ResponseBody
    public Response<Teacher> getInfo(HttpSession session){
        System.out.println("getting info");
        Response<Teacher> response=new Response<Teacher>();
        Teacher teacher=(Teacher)session.getAttribute("teacher");

        if(teacher==null)
        {
            System.out.println("no info");
            response.status=0;

        }
        else{
            Teacher newInfo=teacherService.selectByPrimaryKey(teacher.getTeacherId());
            response.data=newInfo;
            session.setAttribute("teacher",newInfo);
            response.status=1;
        }
        return response;
    }

    @RequestMapping (value = "editInfo.action",method = RequestMethod.POST)
    @ResponseBody
    public int saveInformation(Teacher teacher,HttpSession session
    ){
        Teacher teacher1=(Teacher)session.getAttribute("teacher");
        if(teacher1==null){
            return 0;
        }

        String teacherId=teacher1.getTeacherId();
        teacher.setTeacherId(teacherId);

        int result=teacherService.updateByPrimaryKeySelective(teacher);
        System.out.println("editInfo:"+teacher.getTeacherName()+"teacherId:"+teacherId);
        return result==1?1:0;

    }
    @RequestMapping (value = "/register.action",method = RequestMethod.POST)
    @ResponseBody
    public int register(Teacher teacher,HttpSession session){
        if(teacher==null){
            return 0;
        }


        logger.info("controller-teacher-register:"+teacher.getTeacherId()+teacher.getTeacherPswd());
        try {
            int status=teacherService.register(teacher)==1?1:0;
            return  status;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }



    }

    /**
     * 上传课程视频
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadfiles.action")
    @ResponseBody
    public ModelAndView uploadVideos(MultipartFile file,
                                     HttpServletRequest request
    ) throws IOException {


        String path = request.getSession().getServletContext().getRealPath("upload");
        //String path="e:/test/";
        String fileName = file.getOriginalFilename();
        if(fileName==null)
            return new ModelAndView("redirect:/teacher/fileManager.html");
        System.out.println(path+fileName);
        File dir = new File(path,fileName);
        //File dir=new File("e:/test/123.js");
        //String fileName="123.js";
        if(!dir.exists()){
            dir.mkdirs();
//            dir.getParentFile().mkdir();
        }
        //MultipartFile自带的解析方法
        System.out.println(path);
        file.transferTo(dir);

        Random random = new Random();
        Video video = new Video();
        video.setVideoId("VID"+random.nextInt()+random.nextInt());
        video.setVideoName(fileName);
        video.setVideoCourseId("sdgsdfh");
        video.setVideoUploadDate(new Date(2018-1900,3-1,25));


        video.setVideoPath(path);
        Boolean status = videoService.uploadVideo(video);

        if(status)
            //return "上传成功";
            return new ModelAndView("redirect:/teacher/fileManager.html");
        else
            return null;
    }

    @RequestMapping (value = "/listAllVideo.action",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Video>> listAll(){
        logger.info("controller-video-listAll");
        Response<List<Video>> response= new Response<>();
        List<Video> list=videoService.listAll();

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

}
