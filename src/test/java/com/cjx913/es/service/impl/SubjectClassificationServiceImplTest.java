package com.cjx913.es.service.impl;

import com.cjx913.es.SpringTest;
import com.cjx913.es.entity.domain.SubjectClassification;
import com.cjx913.es.service.SubjectClassificationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class SubjectClassificationServiceImplTest extends SpringTest {

    @Autowired
    private SubjectClassificationService subjectClassificationService;

    @Test
    public void findSubjectbyId() {
    }

    @Test
    public void findAllSubjects() {
    }

    @Test
    public void findAllAvaliableSubjects() {
    }

    @Test
    public void findAllSubjectsIdAndNamesWithPaperCount() {
    }

    @Test
    public void findAllSubjectClassification() {
        SubjectClassification allSubjectClassification = subjectClassificationService.findAllSubjectClassifications();
        assertNotNull(allSubjectClassification);
    }

    @Test
    public void findAllSubjectClassificationChildrenByParentId() {
    }
}