package com.cjx913.es.service.impl;

import com.cjx913.es.mapper.PaperMapper;
import com.cjx913.es.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperMapper paperMapper;
    @Override
    public ArrayList<Map<String, Object>> selectAllPapersIdAndNameBySubjectId(String id) {
        return paperMapper.selectAllPapersIdAndNameBySubjectId(id);
    }

    @Override
    public Map <String, Object> findPaperNameAndPdfPathBySubjectIdAndPaperId(String subjectId, String paperId) {
        return paperMapper.selectPaperNameAndPdfPathBySubjectIdAndPaperId(subjectId,paperId);
    }

    @Override
    public Map <String, Object> findPaperMessageByPaperId(String paperId) {
        return paperMapper.findPaperMessageByPaperId(paperId);
    }

    @Override
    public List<Map <String, Object>> findAllPapersWithExamTimeFullMarkPdfPathWordPath(Long start, Long size, String searchtext, String sortorder) {
        Map<String,Object> map = new HashMap<>();
        map.put("start",start);
        map.put("size",size);
        map.put("searchText",searchtext);
        map.put("order",sortorder);
        return paperMapper.findAllPapersWithExamTimeFullMarkPdfPathWordPath(map);
    }

    public Integer findAllPapersWithExamTimeFullMarkPdfPathWordPathCount(String searchtext, String sortorder) {
        Map<String,Object> map = new HashMap <>();
        map.put("searchText",searchtext);
        map.put("order",sortorder);
        return paperMapper.findAllPapersWithExamTimeFullMarkPdfPathWordPathCount(map);
    }
}
