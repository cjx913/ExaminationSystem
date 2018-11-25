package com.cjx913.es.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface PaperService {
    ArrayList<Map<String,Object>> selectAllPapersIdAndNameBySubjectId(String id);

    Map<String, Object> findPaperNameAndPdfPathBySubjectIdAndPaperId(String subjectId, String paperId);

    Map<String ,Object> findPaperMessageByPaperId( String paperId);

    List<Map<String, Object>> findAllPapersWithExamTimeFullMarkPdfPathWordPath(Long start, Long size, String searchtext, String sortorder);

    Integer findAllPapersWithExamTimeFullMarkPdfPathWordPathCount(String searchtext, String sortorder);
}
