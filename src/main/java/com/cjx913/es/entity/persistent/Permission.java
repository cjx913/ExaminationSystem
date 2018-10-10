package com.cjx913.es.entity.persistent;

import java.util.ArrayList;
import java.util.List;

public class Permission {
    private String id;
    private String permission;
    private String url;
    private int available;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPercode() {
        return permission;
    }

    public void setPercode(String permission) {
        this.permission = permission;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }


}
