package com.cjx913.es.entity.domain;

import com.cjx913.es.entity.persistent.SysPermission;
import com.cjx913.es.entity.persistent.SysRole;

import java.io.Serializable;
import java.security.Principal;
import java.util.List;

public class UserIdentity implements Principal ,Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;//用户id（主键）
    private String account;// 用户账号
    private String username;// 用户名称

    private List<SysPermission> sysPermissions;// 权限
    private List<SysRole> sysRoles;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public List <SysPermission> getSysPermissions() {
        return sysPermissions;
    }

    public void setSysPermissions(List <SysPermission> sysPermissions) {
        this.sysPermissions = sysPermissions;
    }

    public List <SysRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(List <SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    @Override
    public String getName() {
        return this.userId+this.username+this.account;
    }
}
