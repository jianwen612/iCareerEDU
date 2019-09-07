package com.tosit.genius.service;

import com.tosit.genius.entity.Interview;
import com.tosit.genius.entity.User;

import java.util.List;

/**
 * 面试信息业务对象
 */
public interface InterviewService {

    /**
     * 添加新的面试信息
     * @param interview
     * @return
     */
    Boolean insertInterview(Interview interview);

    /**
     * 删除现有的信息
     * @param interviewId
     * @return
     */
    Boolean deleteInterview(String interviewId);

    /**
     * 获得全部面试信息
     * @return
     */
    List<Interview> getAllInterview();

    /**
     *用户获得已参加面试
     * @param userId
     * @return
     */
    List<Interview> getInterviewByUserId(String userId);

    /**
     * 公司获取已发布的面试信息
     * @param companyId
     * @return
     */
    List<Interview> getInterviewByCompanyId(String companyId);

    /**
     * 企业查看发出某一面试接受的用户数
     * @param interviewId
     * @return
     */
    List<User> getUserOfOneInterview(String interviewId);


}
