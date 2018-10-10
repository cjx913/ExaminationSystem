package com.cjx913.es.service;

import com.cjx913.es.entity.persistent.Permission;
import com.cjx913.es.entity.persistent.Role;
import com.cjx913.es.entity.persistent.User;
import com.cjx913.es.exception.CustomException;

import java.util.List;


public interface UserService {
    List<User> findAllUser() throws CustomException;
    User findUserByUsername(String username) throws CustomException;
    User findUserByAccount(String account) throws CustomException;
    void saveUser(User user) throws CustomException;

    List<Permission> findPermissionsByUserId(String userId);

    List<Role> findRolesByUserId(String userId);
}
