package com.cjx913.es.entity.persistent;

import java.util.ArrayList;
import java.util.List;

public class Role {
    public static final Role ADMINISTRATOR=new Role("0000","administrator",1);
    public static final Role ADMIN=new Role("1000","admin",1);
    public static final Role USER=new Role("2000","user",1);

    private String id;
    private String name;
    private int avaliable;

    public Role() {

    }

    public Role(String id, String name, int avaliable) {
        this.id = id;
        this.name = name;
        this.avaliable = avaliable;
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
