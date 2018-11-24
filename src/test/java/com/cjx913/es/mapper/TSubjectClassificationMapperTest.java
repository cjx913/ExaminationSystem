package com.cjx913.es.mapper;

import com.cjx913.es.SpringTest;
import com.cjx913.es.entity.persistent.TSubjectClassification;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TSubjectClassificationMapperTest extends SpringTest {

    @Autowired
    private SubjectClassificationMapper subjectClassificationMapper;

    @Test
    public void insertSubjectClassification() {
        TSubjectClassification TSubjectClassification = new TSubjectClassification();
        TSubjectClassification.setName("/");
        TSubjectClassification.setParent(null);
        Integer integer = subjectClassificationMapper.insertSubjectClassification(TSubjectClassification);
    }

    @Test
    public void selectClassificationById() {
        String name = subjectClassificationMapper.selectSubjectClassificationNameById("7853b119eed611e88345308d99796187");
        System.out.println(name);
    }

    @Test
    public void selectSubjectClassificationById() {
        TSubjectClassification TSubjectClassification = subjectClassificationMapper.selectSubjectClassificationById("f5e03d7aeedb11e88345308d99796187");
        String name = TSubjectClassification.getName();
        while (TSubjectClassification.getParent() != null&&!TSubjectClassification.getParent().equals("")) {
            TSubjectClassification = subjectClassificationMapper.selectSubjectClassificationById(TSubjectClassification.getParent());
            name = TSubjectClassification.getName()+"/"+name;
        }
        System.out.println(name.substring(1));
    }
}