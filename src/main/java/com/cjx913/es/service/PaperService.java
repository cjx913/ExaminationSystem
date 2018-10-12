package com.cjx913.es.service;

import com.cjx913.es.entity.persistent.Paper;
import com.cjx913.es.entity.persistent.PaperFile;

import java.util.List;
import java.util.Map;

public interface PaperService {

    List<Map<String, Object>> findAllSubjectsWithPaperCount();

    List<Paper> findAllPapersBySubjectId(String subjectId);

    Map<String, Object> findPaperNameAndPdfPathBySubjectIdAndPaperId(String subjectId, String paperId);

    Paper savePaperWithWordPath(Paper paper, String wordPath);
}
