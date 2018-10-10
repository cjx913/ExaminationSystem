package com.cjx913.es.entity.domain;

import com.cjx913.es.entity.persistent.Permission;

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

    private List<Permission> permissions;// 权限


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



    public List <Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List <Permission> permissions) {
        this.permissions = permissions;
    }


    @Override
    public String getName() {
        return this.userId+this.username+this.account;
    }
}
