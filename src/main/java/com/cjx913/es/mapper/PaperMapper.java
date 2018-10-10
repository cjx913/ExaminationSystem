package com.cjx913.es.mapper;

import com.cjx913.es.entity.persistent.Paper;
import com.cjx913.es.entity.view.PaperVO;

import java.util.List;

public interface PaperMapper {
    List<PaperVO> selectAllSubjectsWithPaperCount();

    List<Paper> selectAllPapersBySubjectId(String subjectId);

    PaperVO selectPaperBySubjectIdAndPaperId(PaperVO paperVO);

    PaperVO selectPaperNameAndPdfPathBySubjectIdAndPaperId(PaperVO paperVO);
}
