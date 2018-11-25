package com.cjx913.es.mapper;

import com.cjx913.es.SpringTest;
import com.cjx913.es.entity.domain.UserIdentity;
import com.cjx913.es.entity.persistent.SysPermission;
import com.cjx913.es.entity.persistent.SysRole;
import com.cjx913.es.entity.persistent.SysUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class UserMapperTest extends SpringTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectUserByName() {
    }

    @Test
    public void insetUser() {

    }

    @Test
    public void selectPermissionsByUserId() {
        List <SysPermission> permissions = userMapper.selectPermissionsByUserId("0000000");
        assertNotNull(permissions);
    }

    @Test
    public void selectRolesByUserId() {
        List <SysRole> roles = userMapper.selectRolesByUserId("0000000");
        assertNotNull(roles);
    }

    @Test
    public void selectScoreListByUserIdPaginationAndSearch() {
        Map<String,Object> map = new HashMap<>();
        map.put("userId","2000001");
        map.put("start",0);
        map.put("size",2);
        map.put("searchText","");
        map.put("order","");
        List <Map <String, Object>> maps = userMapper.selectScoreListByUserIdPaginationAndSearch(map);
        assert maps!=null;

    }

    @Test
    public void selectAllScoreCountByUserIdSearch() {
    }

    @Test
    public void selectAllUserIdentitiesWithPermissionAndRolesPaginationAndSearch() {
        Map<String,Object> map = new HashMap<>();
        map.put("userId","2000001");
        map.put("start",0);
        map.put("size",2);
        map.put("searchText","");
        map.put("order","");
        List <Map <String, Object>> maps = userMapper.selectAllUserIdentitiesWithPermissionAndRolesPaginationAndSearch(map);
        assert maps!=null;
    }

    @Test
    public void selectAllUserIdentitiesCountSearch() {
    }

//    @Test
//    public void selectUserIdentityWithRoleAndPermissionById() {
//        Map <String, Object> map = userMapper.selectUserIdentityWithRoleAndPermissionById("0000000");
//        assertNotNull(map);
//    }






}