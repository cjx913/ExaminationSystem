package com.cjx913.es.service;


import com.cjx913.es.entity.domain.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SubjectClassificationService {
    Subject findSubjectbyId(String id);
    ArrayList<Subject> findAllSubjects();
    ArrayList<Subject> findAllAvaliableSubjects();


    List<Map<String, Object>> findAllSubjectsIdAndNamesWithPaperCount();
}
