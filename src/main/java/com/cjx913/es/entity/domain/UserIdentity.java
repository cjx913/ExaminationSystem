package com.cjx913.es.entity.domain;

import com.cjx913.es.entity.persistent.SysPermission;
import com.cjx913.es.entity.persistent.SysRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.security.Principal;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@ToString
public class UserIdentity implements Principal ,Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;//用户id（主键）
    private String account;// 用户账号
    private String username;// 用户名称

    private List<SysPermission> permissions;// 权限
    private List<SysRole> roles;

    @Override
    public String getName() {
        return this.userId+this.username+this.account;
    }
}
