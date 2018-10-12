package com.cjx913.es.mapper;

import com.cjx913.es.SpringTest;
import com.cjx913.es.entity.persistent.Paper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class PaperMapperTest extends SpringTest {
    @Autowired
    private PaperMapper paperMapper;

    @Test
    public void selectAllSubjectsWithPaperCount(){
        List <Map <String, Object>> maps = paperMapper.selectAllSubjectsWithPaperCount();
        assert maps!=null;
    }

    @Test
    public void selectAllPapersBySubjectId(){
        List <Paper> papers = paperMapper.selectAllPapersBySubjectId("312");
        assert papers!=null;
    }

    @Test
    public void selectPaperNameAndPdfPathBySubjectIdAndPaperId(){
        Map <String, Object> map = paperMapper.selectPaperNameAndPdfPathBySubjectIdAndPaperId("11", "1233");
        assert map!=null;
    }
}
