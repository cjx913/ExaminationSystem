package com.cjx913.es.service;

import com.cjx913.es.entity.domain.UserIdentity;
import com.cjx913.es.entity.persistent.SysPermission;
import com.cjx913.es.entity.persistent.SysRole;
import com.cjx913.es.entity.persistent.SysUser;
import com.cjx913.es.exception.CustomException;

import java.util.List;
import java.util.Map;


public interface UserService {
    SysUser findUserByName(String username) throws CustomException;

    void saveUser(SysUser sysUser) throws CustomException;

    List <SysPermission> findPermissionsByUserId(String userId) throws CustomException;

    List <SysRole> findRolesByUserId(String userId) throws CustomException;

    List<Map<String,Object>> findScoreListByUserIdPaginationAndSearch(String userId, Long start, Long size, String searchtext, String sortorder);

    Integer findAllScoreCountByUserIdPaginationAndSearch(String userId, String searchtext, String sortorder);

    List<UserIdentity> findAllUserIdentitiesWithPermissionAndRolesPaginationAndSearch(Long start, Long size, String searchtext, String sortorder);

    Integer findAllUserIdentitiesCountSearch(String searchtext, String sortorder);
}
