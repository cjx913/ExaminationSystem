package com.cjx913.es.mapper;

import com.cjx913.es.entity.persistent.Role;

import java.util.List;

public interface RoleMapper {

    List<Role> selectAllRoles();
    List<Role> selectRolesByUserId(String userId);
}
