package com.tosit.genius.service.impl;

import com.tosit.genius.dao.InterviewMapper;
import com.tosit.genius.dao.ReceiveMapper;
import com.tosit.genius.dao.UserMapper;
import com.tosit.genius.entity.Interview;
import com.tosit.genius.entity.Receive;
import com.tosit.genius.entity.User;
import com.tosit.genius.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("interviewService")
public class InterviewServiceImpl implements InterviewService{

    private InterviewMapper interviewMapper;
    private ReceiveMapper receiveMapper;
    private UserMapper userMapper;

    @Autowired
    public InterviewServiceImpl(UserMapper userMapper, InterviewMapper interviewMapper, ReceiveMapper receiveMapper){
        this.interviewMapper = interviewMapper;
        this.receiveMapper = receiveMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Boolean insertInterview(Interview interview) {
        int flag = interviewMapper.insertSelective(interview);
        if(flag == 0)
            return false;
        return true;
    }

    @Override
    public Boolean deleteInterview(String interviewId) {
        int flag = interviewMapper.deleteByPrimaryKey(interviewId);
        if(flag == 0)
            return false;
        return true;
    }

    @Override
    public List<Interview> getAllInterview() {
        return interviewMapper.listAll();
    }

    @Override
    public List<Interview> getInterviewByUserId(String userId) {
        List<Receive> receiveList = receiveMapper.listAll();
        List<String> interviewIdList = new ArrayList<>();
        List<Interview> interviewList = interviewMapper.listAll();
        List<Interview> resultList = new ArrayList<>();
        for(int i = 0; i < receiveList.size(); i++){
            if(userId.equals(receiveList.get(i).getReceiveUserId()))
                interviewIdList.add(receiveList.get(i).getReceiveInterviewId());
        }

        for(int j = 0; j < interviewIdList.size(); j++){
            for(int k = 0; k < interviewList.size(); k++){
                if(interviewIdList.get(j).equals(interviewList.get(k).getInterviewId()))
                    resultList.add(interviewList.get(k));
            }
        }

        return resultList;
    }

    @Override
    public List<Interview> getInterviewByCompanyId(String companyId) {
        List<Interview> interviewList = interviewMapper.listAll();
        List<Interview> resultList = new ArrayList<>();
        for(int i = 0; i < interviewList.size(); i++){
            if(interviewList.get(i).getInterviewCompanyId().equals(companyId))
                resultList.add(interviewList.get(i));
        }
        return resultList;
    }

    @Override
    public List<User> getUserOfOneInterview(String interviewId) {
        List<Receive> receiveList = receiveMapper.listAll();
        List<String> newList = new ArrayList<>();
        List<User> userList = userMapper.listAll();
        List<User> resultList = new ArrayList<>();
        for (int i =0;i <receiveList.size();i++){
            if(interviewId.equals(receiveList.get(i).getReceiveInterviewId()))
                newList.add(receiveList.get(i).getReceiveUserId());
        }

        for(int j = 0; j < newList.size(); j++){
            for(int k = 0; k < userList.size(); k++){
                if(newList.get(j).equals(userList.get(k).getUserId()))
                    resultList.add(userList.get(k));
            }
        }

        return resultList;
    }
}
