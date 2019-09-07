package com.tosit.genius.service.impl;

import com.tosit.genius.dao.SubjectMapper;
import com.tosit.genius.entity.Subject;
import com.tosit.genius.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("subjectService")

public class SubjectServiceImpl implements SubjectService{

    private SubjectMapper subjectMapper;

    @Autowired

    public SubjectServiceImpl(SubjectMapper subjectMapper){
        this.subjectMapper = subjectMapper;
    }

    @Override
    public List<Subject> listAllSubjects() {
        return subjectMapper.listAll();
    }

    @Override
    public Subject searchById(String subjectId) {
        return subjectMapper.selectByPrimaryKey(subjectId);
    }

}
