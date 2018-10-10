package com.cjx913.es.service.impl;

import java.util.List;

import com.cjx913.es.entity.persistent.Permission;
import com.cjx913.es.entity.persistent.Role;
import com.cjx913.es.entity.persistent.User;
import com.cjx913.es.exception.CustomException;
import com.cjx913.es.mapper.UserMapper;
import com.cjx913.es.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List <User> findAllUser() throws CustomException {
        return userMapper.selectAllUser();
    }

    @Override
    public User findUserByUsername(String username) throws CustomException {
        return userMapper.selectUserByUsername(username);
    }

    @Override
    public User findUserByAccount(String account) throws CustomException {
        return userMapper.selectUserByAccount(account);
    }

    @Override
    public void saveUser(User user) throws CustomException {
        userMapper.insetUser(user);
    }

    @Override
    public List <Permission> findPermissionsByUserId(String userId) {
        return userMapper.selectPermissionsByUserId(userId);
    }

    @Override
    public List <Role> findRolesByUserId(String userId) {
        return userMapper.selectRolesByUserId(userId);
    }
}
