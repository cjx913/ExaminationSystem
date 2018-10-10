package com.cjx913.es.mapper;

import java.util.List;

import com.cjx913.es.entity.persistent.SysUser;
import com.cjx913.es.exception.CustomException;

public interface UserMapper {
    List<SysUser> selectAllSysUser() throws CustomException;
    SysUser selectSysUserByUsername(String username) throws CustomException;
    SysUser selectSysUserByAccount(String account) throws CustomException;
    void insetSysUser(SysUser sysUser) throws CustomException;
}
