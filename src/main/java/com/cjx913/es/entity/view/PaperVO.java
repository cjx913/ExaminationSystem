package com.cjx913.es.entity.view;


public class PaperVO {

    private String paperId;
    private String PaperName;
    private int paperPanduanti;
    private int paperDanxuanti;
    private int paperDuoxuanti;
    private int paperTiankongti;
    private int paperJiedati;

    private String paperWordPath;
    private String paperPdfPath;

    private String subjectId;
    private String subjectName;

    private int subjectPaperCount;

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return PaperName;
    }

    public void setPaperName(String paperName) {
        PaperName = paperName;
    }

    public int getPaperPanduanti() {
        return paperPanduanti;
    }

    public void setPaperPanduanti(int paperPanduanti) {
        this.paperPanduanti = paperPanduanti;
    }

    public int getPaperDanxuanti() {
        return paperDanxuanti;
    }

    public void setPaperDanxuanti(int paperDanxuanti) {
        this.paperDanxuanti = paperDanxuanti;
    }

    public int getPaperDuoxuanti() {
        return paperDuoxuanti;
    }

    public void setPaperDuoxuanti(int paperDuoxuanti) {
        this.paperDuoxuanti = paperDuoxuanti;
    }

    public int getPaperTiankongti() {
        return paperTiankongti;
    }

    public void setPaperTiankongti(int paperTiankongti) {
        this.paperTiankongti = paperTiankongti;
    }

    public int getPaperJiedati() {
        return paperJiedati;
    }

    public void setPaperJiedati(int paperJiedati) {
        this.paperJiedati = paperJiedati;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getPaperWordPath() {
        return paperWordPath;
    }

    public void setPaperWordPath(String paperWordPath) {
        this.paperWordPath = paperWordPath;
    }

    public String getPaperPdfPath() {
        return paperPdfPath;
    }

    public void setPaperPdfPath(String paperPdfPath) {
        this.paperPdfPath = paperPdfPath;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectPaperCount() {
        return subjectPaperCount;
    }

    public void setSubjectPaperCount(int subjectPaperCount) {
        this.subjectPaperCount = subjectPaperCount;
    }
}
