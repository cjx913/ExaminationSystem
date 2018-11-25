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


public class SysUserMapperTest extends SpringTest {
    @Autowired
    private UserMapper userMapper;



    @Test
    public void insertUser(){
        SysUser sysUser = new SysUser();
        sysUser.setAccount("123132422124321");
        sysUser.setName("abcde53rfgh");
        sysUser.setPassword("abcdefgh");
        sysUser.setSalt("abcd");
        sysUser.setLocked(0);
        userMapper.insetUser(sysUser);
    }

    @Test
    public void selectUserByName(){
        SysUser sysUser = userMapper.selectUserByName("cjx913");
        assert sysUser !=null;
    }

    @Test
    public void findPermissionsByUserId(){
        List<SysPermission> sysPermissions = userMapper.selectPermissionsByUserId("0000000");
        assert sysPermissions !=null;
    }

    @Test
    public void selectRolesByUserId(){
        List<SysRole> sysRoles = userMapper.selectRolesByUserId("1000000");
        assert sysRoles !=null;
    }

    @Test
    public void selectScoreListPaginationAndSearch(){
        Map<String,Object> map = new HashMap <>();
        map.put("userId","2000001");
        map.put("start",0);
        map.put("size",3);
        map.put("searchText",null);
        map.put("order","asc".toUpperCase());
        List <Map <String, Object>> scoreLists = userMapper.selectScoreListByUserIdPaginationAndSearch(map);
        assert scoreLists!=null&&scoreLists.size()>0;
    }

    @Test
    public void selectAllScoreCountByUserIdPaginationAndSearch(){
        Map<String,Object> map = new HashMap <>();
        map.put("userId","2000001");
        map.put("searchText","CET-6");
        map.put("order","asc".toUpperCase());
        Integer count = userMapper.selectAllScoreCountByUserIdSearch(map);
        assert count!=null;
    }
    
    @Test
    public void selectAllUserIdentitiesPaginationAndSearch(){
//        Map<String,Object> map = new HashMap <>();
//        map.put("start",0);
//        map.put("size",10);
//        map.put("searchText",null);
//        map.put("order",null);
//        List <UserIdentity> userIdentities = userMapper.selectAllUserIdentitiesWithPermissionAndRolesPaginationAndSearch(map);
//        assert userIdentities!=null&&userIdentities.size()>0;
//
//        for(UserIdentity userIdentity:userIdentities){
//            List <SysPermission> sysPermissions = userIdentity.getPermissions();
//            System.out.println( sysPermissions !=null);
//        }

    }

}
