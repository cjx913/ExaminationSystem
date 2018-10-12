package com.cjx913.es.mapper;

import com.cjx913.es.entity.persistent.Paper;
import com.cjx913.es.entity.persistent.PaperFile;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface PaperMapper {
    @Results(id = "subjectWithPaperCount", value = {
            @Result(column = "id", property = "id", javaType = String.class),
            @Result(column = "name", property = "name", javaType = String.class),
            @Result(column = "avaliable", property = "avaliable", javaType = String.class),
            @Result(column = "paperCount", property = "paperCount", javaType = int.class),
    })
    @Select({"select s.id,s.name,s.avaliable,count(p.id) as paperCount",
            "from t_subject as s left outer join t_paper as p",
            "on s.id=p.subject_id",
            "group by s.id"})
    List <Map <String, Object>> selectAllSubjectsWithPaperCount();

    @Select({"select id,subject_id as subjectId,name,panduanti,danxuanti,duoxuanti,tiankongti,jiedati",
            "from t_paper where subject_id=#{subjectId}"})
    List <Paper> selectAllPapersBySubjectId(String subjectId);

    @Select({"select p.name as paperName,pf.pdf_path as pdfPath",
            "from t_paper as p,t_paper_file as pf",
            "where p.subject_id=#{subjectId} and p.id=#{paperId} and p.id=pf.paper_id"})
    Map <String, Object> selectPaperNameAndPdfPathBySubjectIdAndPaperId(@Param("subjectId") String subjectId, @Param("paperId") String paperId);

    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '') as id from dual")
    @Insert({" insert into t_paper(id, subject_id, name, panduanti, danxuanti, duoxuanti,tiankongti,jiedati)",
            "values (#{id},#{subjectId},#{name},#{panduanti},#{danxuanti},#{duoxuanti},#{tiankongti},#{jiedati})"})
    Integer insertPaper(Paper paper);

    @Insert(value = {"insert into t_paper_file(paper_id,word_path)",
            "values(#{paperId},#{wordPath})"})
    Integer insertPaperWordPath(PaperFile paperFile);

    @Insert(value = {"insert into t_paper_file(paper_id,pdf_path)",
            "values(#{paperId},#{pdfPath})"})
    Integer insertPaperPdfPath(PaperFile paperFile);


    @Select({"select id,subject_Id as subjectId,name,panduanti,danxuanti,duoxuanti,tiankongti,jiedati",
            "from t_paper",
            "where subject_id=#{subjectId} and id=#{paperId}"})
    Paper selectPaperBySubjectIdAndPaperId(@Param("subjectId") String subjectId, @Param("paperId") String paperId);

}
