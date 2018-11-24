package com.cjx913.es.mapper;

import com.cjx913.es.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;

public class PaperMapperTest extends SpringTest {
    @Autowired
    private PaperMapper paperMapper;

    @Test
    public void selectAllPapersIdAndNameBySubjectId() {
        ArrayList <Map <String, Object>> maps = paperMapper.selectAllPapersIdAndNameBySubjectId("f5e03d7aeedb11e88345308d99796187");
        assert maps!=null;
    }
}