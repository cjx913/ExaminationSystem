package com.cjx913.es.service;

import com.cjx913.es.entity.persistent.Paper;
import com.cjx913.es.entity.view.PaperVO;

import java.util.List;

public interface PaperService {
    List<PaperVO> findAllSubjectsWithPaperCount();

    List<Paper> findAllPapersBySubjectId(String subjectId);

    PaperVO findPaperWithPdfPathBySubjectIdAndPaperId(String subjectId, String paperId);

    PaperVO findPaperNameAndPdfPathBySubjectIdAndPaperId(String subjectId, String paperId);
}
