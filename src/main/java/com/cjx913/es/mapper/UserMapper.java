package com.cjx913.es.mapper;

import java.util.List;

import com.cjx913.es.entity.persistent.Permission;
import com.cjx913.es.entity.persistent.Role;
import com.cjx913.es.entity.persistent.User;
import com.cjx913.es.exception.CustomException;

public interface UserMapper {
    List<User> selectAllUser() throws CustomException;
    User selectUserByUsername(String username) throws CustomException;
    User selectUserByAccount(String account) throws CustomException;
    void insetUser(User user) throws CustomException;

    List<Permission> selectPermissionsByUserId(String userId);

    List<Role> selectRolesByUserId(String userId);
}
