package com.cjx913.es.service.impl;

import com.cjx913.es.SpringTest;
import com.cjx913.es.entity.domain.Subject;
import com.cjx913.es.service.SubjectClassificationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;

public class TSubjectClassificationServiceImplTest extends SpringTest {

    @Autowired
    private SubjectClassificationService subjectClassificationService;
    @Test
    public void findSubjectbyId() {
        Subject subject = subjectClassificationService.findSubjectbyId("f5e03d7aeedb11e88345308d99796187");
        System.out.println(subject);
    }

    @Test
    public void findAllSubjects() {
        ArrayList <Subject> subjects = subjectClassificationService.findAllSubjects();
        assertNotNull(subjects);
    }


    @Test
    public void findAllAvaliableSubjects() {

        ArrayList <Subject> subjects = subjectClassificationService.findAllAvaliableSubjects();
        assertNotNull(subjects);
    }
}