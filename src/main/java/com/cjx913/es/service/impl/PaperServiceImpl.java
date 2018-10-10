package com.cjx913.es.service.impl;

import com.cjx913.es.entity.persistent.Paper;
import com.cjx913.es.entity.view.PaperVO;
import com.cjx913.es.mapper.PaperMapper;
import com.cjx913.es.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperMapper paperMapper;
    @Override
    public List<PaperVO> findAllSubjectsWithPaperCount() {
        return paperMapper.selectAllSubjectsWithPaperCount();
    }

    @Override
    public List <Paper> findAllPapersBySubjectId(String subjectId) {
        return paperMapper.selectAllPapersBySubjectId(subjectId);
    }

    @Override
    public PaperVO findPaperWithPdfPathBySubjectIdAndPaperId(String subjectId, String paperId) {
        PaperVO paperVO = new PaperVO();
        paperVO.setSubjectId(subjectId);
        paperVO.setPaperId(paperId);
        return paperMapper.selectPaperBySubjectIdAndPaperId(paperVO);
    }

    @Override
    public PaperVO findPaperNameAndPdfPathBySubjectIdAndPaperId(String subjectId, String paperId) {
        PaperVO paperVO = new PaperVO();
        paperVO.setSubjectId(subjectId);
        paperVO.setPaperId(paperId);
        return paperMapper.selectPaperNameAndPdfPathBySubjectIdAndPaperId(paperVO);
    }


}
