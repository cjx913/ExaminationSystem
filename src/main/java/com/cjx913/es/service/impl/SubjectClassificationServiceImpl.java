package com.cjx913.es.service.impl;

import com.cjx913.es.entity.domain.Subject;
import com.cjx913.es.entity.domain.SubjectClassification;
import com.cjx913.es.entity.persistent.TSubjectClassification;
import com.cjx913.es.mapper.SubjectClassificationMapper;
import com.cjx913.es.service.SubjectClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

@Service
@Transactional
public class SubjectClassificationServiceImpl implements SubjectClassificationService {
    @Autowired
    private SubjectClassificationMapper subjectClassificationMapper;


    /**
     * @param id
     * @return subject
     */
    @Override
    public Subject findSubjectbyId(String id) {
        Subject subject = new Subject();

        TSubjectClassification TSubjectClassification = subjectClassificationMapper.selectSubjectClassificationById(id);
        subject.setId(TSubjectClassification.getId());
        subject.setName(TSubjectClassification.getName());

        String classification = "";
        while (TSubjectClassification.getParent() != null && !TSubjectClassification.getParent().equals("00000000000000000000000000000000")) {
            TSubjectClassification = subjectClassificationMapper.selectSubjectClassificationById(TSubjectClassification.getParent());
            classification = TSubjectClassification.getName() + "/" + classification;
        }
        classification = "/" + classification;
        subject.setClassification(classification);
        return subject;
    }

    @Override
    public ArrayList <Subject> findAllSubjects() {
        ArrayList <TSubjectClassification> TSubjectClassifications = subjectClassificationMapper.selectAllSubjectClassifications();
        ArrayList <Subject> subjects = new ArrayList <>();

        Subject subject;
        String classification;
        for (TSubjectClassification TSubjectClassification : TSubjectClassifications) {
            subject = new Subject();
            subject.setId(TSubjectClassification.getId());
            subject.setName(TSubjectClassification.getName());
            classification = "";
            while (TSubjectClassification.getParent() != null && !TSubjectClassification.getParent().equals("00000000000000000000000000000000")) {
                TSubjectClassification = subjectClassificationMapper.selectSubjectClassificationById(TSubjectClassification.getParent());
                classification = TSubjectClassification.getName() + "/" + classification;
            }
            classification = "/" + classification;
            subject.setClassification(classification);
            subjects.add(subject);
        }
        return subjects;
    }



    @Override
    public ArrayList <Subject> findAllAvaliableSubjects() {
        ArrayList <TSubjectClassification> TSubjectClassifications = subjectClassificationMapper.selectAllAvaliableSubjectClassifications();
        ArrayList <Subject> subjects = new ArrayList <>();

        Subject subject;
        String classification;
        for (TSubjectClassification TSubjectClassification : TSubjectClassifications) {
            subject = new Subject();
            subject.setId(TSubjectClassification.getId());
            subject.setName(TSubjectClassification.getName());
            classification = "";
            while (TSubjectClassification.getParent() != null && !TSubjectClassification.getParent().equals("00000000000000000000000000000000")) {
                TSubjectClassification = subjectClassificationMapper.selectSubjectClassificationById(TSubjectClassification.getParent());
                classification = TSubjectClassification.getName() + "/" + classification;
            }
            classification = "/" + classification;
            subject.setClassification(classification);
            subjects.add(subject);
        }
        return subjects;
    }

    @Override
    public List<Map<String, Object>> findAllSubjectsIdAndNamesWithPaperCount() {
        return subjectClassificationMapper.selectAllAvaliableSubjectClassificationsIdAndNameWithPaperCount();
    }

    @Override
    public SubjectClassification findAllSubjectClassifications() {
        SubjectClassification subjectClassification =subjectClassificationMapper.selectSubjectClassificationRoot();

        subjectClassification = recursionFindSubjectClassification(subjectClassification);

        return subjectClassification;
    }

    private SubjectClassification recursionFindSubjectClassification(SubjectClassification subjectClassification){
        ArrayList <SubjectClassification> list = findAllSubjectClassificationChildrenByParentId(subjectClassification.getId());
        if(list==null){
            return subjectClassification;
        }else {
            subjectClassification.setChildren(list);
            for (SubjectClassification classification : subjectClassification.getChildren()) {
//                classification.setParent(subjectClassification);
                recursionFindSubjectClassification(classification);
            }
        }
        return subjectClassification;
    }

    public ArrayList<SubjectClassification> findAllSubjectClassificationChildrenByParentId(String parentId){
        return subjectClassificationMapper.selectSubjectClassificationChildrenByParentId(parentId);
    }
}
