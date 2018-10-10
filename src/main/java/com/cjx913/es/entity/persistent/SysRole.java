package com.cjx913.es.entity.persistent;

import java.util.ArrayList;
import java.util.List;

public class SysRole {
    private String id;
    private String name;
    private String avaliable;

    private List<SysUser> sysUsers;
    private List<SysPermission> sysPermissions;

    public SysRole() {
        sysUsers = new ArrayList <>();
        sysPermissions = new ArrayList <>();
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

    public String getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(String avaliable) {
        this.avaliable = avaliable;
    }
}
