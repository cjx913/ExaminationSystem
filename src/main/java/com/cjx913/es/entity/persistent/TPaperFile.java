package com.cjx913.es.entity.persistent;

public class TPaperFile {
    private String paperId;
    private String wordPath;
    private String pdfPath;

    public TPaperFile() {
    }

    public TPaperFile(String paperId, String wordPath) {
        this.paperId = paperId;
        this.wordPath = wordPath;
    }

    public TPaperFile(String paperId, String wordPath, String pdfPath) {
        this.paperId = paperId;
        this.wordPath = wordPath;
        this.pdfPath = pdfPath;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getWordPath() {
        return wordPath;
    }

    public void setWordPath(String wordPath) {
        this.wordPath = wordPath;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }
}
