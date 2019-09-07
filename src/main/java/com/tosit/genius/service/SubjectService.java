package com.tosit.genius.service;

import com.tosit.genius.entity.Subject;

import java.util.List;

/**
 * 科目业务对象
 */

public interface SubjectService {

    /**
     * 获取所有科目分类
     * @return
     */
    List<Subject> listAllSubjects();

    /**
     * 根据科目id获取科目
     * @param subjectId
     * @return
     */
    Subject searchById(String subjectId);

}
