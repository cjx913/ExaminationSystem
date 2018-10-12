package com.cjx913.es.Service;

import com.cjx913.es.SpringTest;
import com.cjx913.es.entity.persistent.Paper;
import com.cjx913.es.service.PaperService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PaperServiceTest extends SpringTest {
    @Autowired
    private PaperService paperService;
    @Test
    public void savePaperWithWordPath(){
        Paper paper = new Paper(null,"11","hello",5,10,8,5,4);
        String wordPath="e:/esa";
        paper = paperService.savePaperWithWordPath(paper, wordPath);
        assert paper!=null;
    }
}
