package com.cjx913.es.entity.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ExamResult {
    private String id;
    private String userName;
    private String subjectName;
    private String paperName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date examTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date publishTime;
    private int score;

    public ExamResult(String id, String userName, String subjectName, String paperName, Date examTime, Date publishTime, int score) {
        this.id = id;
        this.userName = userName;
        this.subjectName = subjectName;
        this.paperName = paperName;
        this.examTime = examTime;
        this.publishTime = publishTime;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
