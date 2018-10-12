package com.cjx913.es.service.impl;

import com.cjx913.es.entity.persistent.Paper;
import com.cjx913.es.mapper.PaperMapper;
import com.cjx913.es.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperMapper paperMapper;

    @Override
    public List <Map<String, Object>> findAllSubjectsWithPaperCount() {
        return paperMapper.selectAllSubjectsWithPaperCount();
    }

    @Override
    public List <Paper> findAllPapersBySubjectId(String subjectId) {
        return paperMapper.selectAllPapersBySubjectId(subjectId);
    }

    @Override
    public Map <String, Object> findPaperNameAndPdfPathBySubjectIdAndPaperId(String subjectId, String paperId) {
        return paperMapper.selectPaperNameAndPdfPathBySubjectIdAndPaperId(subjectId,paperId);
    }
}
