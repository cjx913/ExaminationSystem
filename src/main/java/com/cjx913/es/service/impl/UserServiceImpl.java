package com.cjx913.es.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cjx913.es.entity.persistent.SysPermission;
import com.cjx913.es.entity.persistent.SysRole;
import com.cjx913.es.entity.persistent.SysUser;
import com.cjx913.es.exception.CustomException;
import com.cjx913.es.mapper.UserMapper;
import com.cjx913.es.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public SysUser findUserByName(String username) throws CustomException {
        return userMapper.selectUserByName(username);
    }

    @Override
    public SysUser saveUser(SysUser sysUser) throws CustomException {
        String password = new Md5Hash(sysUser.getPassword(), sysUser.getSalt(), 1).toString();
        sysUser.setPassword(password);
        sysUser.setAccount(String.valueOf((int)(2000000+Math.random()*1000000)));
        while (userMapper.selectUserCountByAccount(sysUser.getAccount())>0){
            sysUser.setAccount(String.valueOf((int)(10000000+Math.random()*100000000)));
        }
        Integer integer = userMapper.insetUser(sysUser);
        SysUser user = userMapper.selectUserByNameAndPassword(sysUser.getName(), sysUser.getPassword());
        userMapper.setUserRole(user.getId());
        return user;
    }

    @Override
    public List <SysPermission> findPermissionsByUserId(String userId) {
        return userMapper.selectPermissionsByUserId(userId);
    }

    @Override
    public List <SysRole> findRolesByUserId(String userId) {
        return userMapper.selectRolesByUserId(userId);
    }

    @Override
    public List <Map <String, Object>> findScoreListByUserIdPaginationAndSearch(String userId, Long start, Long size, String searchtext, String sortorder) {
        Map<String,Object> map = new HashMap <>();
        map.put("userId",userId);
        map.put("start",start);
        map.put("size",size);
        map.put("searchText",searchtext);
        map.put("order",sortorder);
        return userMapper.selectScoreListByUserIdPaginationAndSearch(map);
    }


    @Override
    public Integer findAllScoreCountByUserIdPaginationAndSearch(String userId, String searchtext, String sortorder) {
        Map<String,Object> map = new HashMap <>();
        map.put("userId",userId);
        map.put("searchText",searchtext);
        map.put("order",sortorder);
        return userMapper.selectAllScoreCountByUserIdSearch(map);
    }

    @Override
    public List <Map <String, Object>> findAllUserIdentitiesWithPermissionAndRolesPaginationAndSearch(Long start, Long size, String searchtext, String sortorder) {
        Map<String,Object> map = new HashMap <>();
        map.put("start",start);
        map.put("size",size);
        map.put("searchText",searchtext);
        map.put("order",sortorder);
        return userMapper.selectAllUserIdentitiesWithPermissionAndRolesPaginationAndSearch(map);
    }

    @Override
    public Integer findAllUserIdentitiesCountSearch(String searchtext, String sortorder) {
        Map<String,Object> map = new HashMap <>();
        map.put("searchText",searchtext);
        map.put("order",sortorder);
        return userMapper.selectAllUserIdentitiesCountSearch(map);
    }

    @Override
    public Integer deleteUserByUserId(String userId) {
        return userMapper.deleteUserByUserId(userId);
    }
}
