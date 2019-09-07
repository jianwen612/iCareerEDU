package com.tosit.genius.service.impl;

import com.tosit.genius.dao.ParticipateMapper;
import com.tosit.genius.entity.Participate;
import com.tosit.genius.service.ParticipateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("participateService")
public class ParticipateServiceImpl implements ParticipateService {

    private ParticipateMapper participateMapper;

    @Autowired
    public ParticipateServiceImpl(ParticipateMapper participateMapper){
        this.participateMapper = participateMapper;
    }

    @Override
    public List<Participate> selectGradesByTestId(String testId) {
        List<Participate> participateList = participateMapper.listAll();
        List<Participate> newList = new ArrayList<>();
        for(int i = 0; i < participateList.size(); i++){
            if(participateList.get(i).getParticipateTestId().equals(testId))
                newList.add(participateList.get(i));
        }
        return newList;
    }
}
