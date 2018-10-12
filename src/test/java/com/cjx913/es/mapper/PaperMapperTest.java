package com.cjx913.es.mapper;

import com.cjx913.es.SpringTest;
import com.cjx913.es.entity.persistent.Paper;
import com.cjx913.es.entity.persistent.PaperFile;
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

    @Test
    public void insertPaper(){
        Paper paper = new Paper(null,"11","111hello",5,10,8,5,4);
        Integer integer =  paperMapper.insertPaper(paper);
        assert paper.getId()!=null;
    }

    @Test
    public void insertPaperWordPath(){
        PaperFile paperFile = new PaperFile("070c8a25cdc311e88e71308d99796187","e:/dada","E:/asdasd");
        paperMapper.insertPaperWordPath(paperFile);
        assert paperFile!=null;
    }

    @Test
    public void selectPaperBySubjectIdAndPaperId(){
        Paper paper = paperMapper.selectPaperBySubjectIdAndPaperId("312","123");
        assert paper!=null;
    }
}
