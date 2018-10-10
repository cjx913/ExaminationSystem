package com.cjx913.es.service;

import com.cjx913.es.entity.persistent.SysUser;
import com.cjx913.es.exception.CustomException;

import java.util.List;


public interface UserService {
    List<SysUser> findAllSysUser() throws CustomException;
    SysUser findSysUserByUsername(String username) throws CustomException;
    SysUser findSysUserByAccount(String account) throws CustomException;
    void saveSysUser(SysUser sysUser) throws CustomException;
}
