package com.cjx913.es.mapper;

import com.cjx913.es.entity.domain.SubjectClassification;
import com.cjx913.es.entity.persistent.TSubjectClassification;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SubjectClassificationMapper {

    /**
     * save
     *
     * @param TSubjectClassification
     * @return
     */
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '') as id from dual")
    @Insert(value = {"insert into t_subject_classification(id,name,parent,avaliable)",
            "values(#{id},#{name},#{parent},#{avaliable})"})
    Integer insertSubjectClassification(TSubjectClassification TSubjectClassification);

    /**
     * selectAllAvaliableSubjectClassifications
     *
     * @return
     */
    @Select({"select id,name,parent,avaliable", "from t_subject_classification", "where avaliable=1"})
    ArrayList <TSubjectClassification> selectAllAvaliableSubjectClassifications();

    /**
     * selectAllAvaliableSubjectClassificationsIdAndNameWithPaperCount
     * 返回subjectId,subjectName,paperCount
     * @return ArrayList<Map <String, Object>>
     */
    @Select({"select s.id as subjectId,s.name as subjectName,COUNT(s.id) as paperCount",
            "from t_subject_classification as s inner join t_paper as p",
            "where s.id=p.subject_id and avaliable=1",
            "group by s.id;"})
    ArrayList<Map <String, Object>> selectAllAvaliableSubjectClassificationsIdAndNameWithPaperCount();

    /**
     * selectAllSubjectClassifications
     *
     * @return
     */
    @Select({"select id,name,parent,avaliable", "from t_subject_classification"})
    ArrayList <TSubjectClassification> selectAllSubjectClassifications();

    /**
     * selectSubjectClassificationById
     *
     * @param id
     * @return
     */
    @Select({"select id,name,parent,avaliable", "from t_subject_classification", "where id=#{id}"})
    TSubjectClassification selectSubjectClassificationById(@Param("id") String id);

    /**
     * selectSubjectClassificationNameById
     *
     * @param id
     * @return
     */
    @Select({"select name", "from t_subject_classification", "where id=#{id}"})
    String selectSubjectClassificationNameById(@Param("id") String id);

    /**
     * deleteSubjectClassificationByParent
     *
     * @param parent
     * @return
     */
    @Delete({"delete from t_subject_classification", "where parent=#{parent}"})
    Integer deleteSubjectClassificationByParent(@Param("parent") String parent);


    @Select({"select id,name,parent as parentId,avaliable", "from t_subject_classification", "where id='00000000000000000000000000000000'"})
    SubjectClassification selectSubjectClassificationRoot();

    @Select({"select id,name,parent as parentId,avaliable", "from t_subject_classification", "where id!='00000000000000000000000000000000' and parent=#{parentId}"})
    ArrayList<SubjectClassification> selectSubjectClassificationChildrenByParentId(@Param("parentId") String parentId);
}
