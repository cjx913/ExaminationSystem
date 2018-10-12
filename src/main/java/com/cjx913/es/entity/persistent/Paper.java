package com.cjx913.es.entity.persistent;

public class Paper {
    private String id;
    private String subjectId;
    private String name;
    private int panduanti;
    private int danxuanti;
    private int duoxuanti;
    private int tiankongti;
    private int jiedati;

    public Paper() {
    }

    public Paper(String id, String subjectId, String name, int panduanti, int danxuanti, int duoxuanti, int tiankongti, int jiedati) {
        this.id = id;
        this.subjectId = subjectId;
        this.name = name;
        this.panduanti = panduanti;
        this.danxuanti = danxuanti;
        this.duoxuanti = duoxuanti;
        this.tiankongti = tiankongti;
        this.jiedati = jiedati;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubject_id(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPanduanti() {
        return panduanti;
    }

    public void setPanduanti(int panduanti) {
        this.panduanti = panduanti;
    }

    public int getDanxuanti() {
        return danxuanti;
    }

    public void setDanxuanti(int danxuanti) {
        this.danxuanti = danxuanti;
    }

    public int getDuoxuanti() {
        return duoxuanti;
    }

    public void setDuoxuanti(int duoxuanti) {
        this.duoxuanti = duoxuanti;
    }

    public int getTiankongti() {
        return tiankongti;
    }

    public void setTiankongti(int tiankongti) {
        this.tiankongti = tiankongti;
    }

    public int getJiedati() {
        return jiedati;
    }

    public void setJiedati(int jiedati) {
        this.jiedati = jiedati;
    }
}
