package com.cjx913.es.entity.persistent;

public class Subject {
    private String id;
    private String name;
    private int avaliable;

    public Subject(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Subject(String subjectId) {
        this.id = subjectId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(int avaliable) {
        this.avaliable = avaliable;
    }
}
