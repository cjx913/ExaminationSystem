package com.cjx913.es.entity.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ScoreList {
    private String id;
    private String subjectName;
    private String paperName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date commitTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date evaluationTime;
    private int score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public Date getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(Date evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
