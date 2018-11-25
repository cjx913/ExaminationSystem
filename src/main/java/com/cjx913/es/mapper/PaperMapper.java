package com.cjx913.es.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface PaperMapper {
    /**
     * selectAllPapersIdAndNameBySubjectId
     * map(paperId,paperName)
     *
     * @param subjectId
     * @return
     */
    @Select({"select id as paperId,name as paperName",
            "from t_paper",
            "where subject_id=#{subjectId}",
            "order by name asc"})
    ArrayList <Map <String, Object>> selectAllPapersIdAndNameBySubjectId(@Param("subjectId") String subjectId);


    /**
     * selectPaperNameAndPdfPathBySubjectIdAndPaperId
     * return map(paperName,pdfPath)
     * @param subjectId
     * @param paperId
     * @return
     */
    @Select({"select p.name as paperName,f.pdf_path as pdfPath",
            "from t_paper as p inner join t_paper_file as f on p.id = f.paper_id",
            "where p.id=#{paperId} and p.subject_id =#{subjectId}"})
    Map <String, Object> selectPaperNameAndPdfPathBySubjectIdAndPaperId(@Param("subjectId") String subjectId,@Param("paperId") String paperId);


    /**
     * map(paperName,paperId,panduanti,danxuanti,duoxaunti,tiankongti,jiedati,examTime,fullMark)
     * findPaperMessageByPaperId
     * @param paperId
     * @return
     */
    @Select({"select p.name as paperName,m.paper_id as paperId,m.panduanti,m.danxuanti,m.duoxuanti,m.tiankongti,m.jiedati,m.exam_time as examTime,m.full_mark as fullMark",
            "from t_paper as p inner join t_paper_message as m on p.id=m.paper_id",
            "where p.id=#{paperId}"})
    Map<String, Object> findPaperMessageByPaperId(@Param("paperId") String paperId);

    List<Map<String, Object>> findAllPapersWithExamTimeFullMarkPdfPathWordPath(Map<String,Object> map);

    Integer findAllPapersWithExamTimeFullMarkPdfPathWordPathCount(Map<String,Object> map);
}
