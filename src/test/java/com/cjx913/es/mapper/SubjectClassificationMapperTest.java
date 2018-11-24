package com.cjx913.es.mapper;

import com.cjx913.es.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;

public class SubjectClassificationMapperTest extends SpringTest {

    @Autowired
    private SubjectClassificationMapper subjectClassificationMapper;

    @Test
    public void selectAllAvaliableSubjectClassificationNamesWithCount() {
        ArrayList <Map <String, Object>> maps = subjectClassificationMapper.selectAllAvaliableSubjectClassificationsIdAndNameWithPaperCount();
        assertNotNull(maps);
    }
}