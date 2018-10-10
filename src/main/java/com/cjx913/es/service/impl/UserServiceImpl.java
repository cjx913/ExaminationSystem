package com.cjx913.es.service.impl;

import java.util.List;

import com.cjx913.es.entity.persistent.SysUser;
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
    public List <SysUser> findAllSysUser() throws CustomException {
        return userMapper.selectAllSysUser();
    }

    @Override
    public SysUser findSysUserByUsername(String username) throws CustomException {
        return userMapper.selectSysUserByUsername(username);
    }

    @Override
    public SysUser findSysUserByAccount(String account) throws CustomException {
        return userMapper.selectSysUserByAccount(account);
    }

    @Override
    public void saveSysUser(SysUser sysUser) throws CustomException {
        userMapper.insetSysUser(sysUser);
    }
}
