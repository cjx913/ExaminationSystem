package com.cjx913.es.mapper;


import com.cjx913.es.SpringTest;
import com.cjx913.es.entity.domain.ScoreList;
import com.cjx913.es.entity.domain.UserIdentity;
import com.cjx913.es.entity.persistent.Permission;
import com.cjx913.es.entity.persistent.Role;
import com.cjx913.es.entity.persistent.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserMapperTest extends SpringTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertUser(){
        User user = new User();
        user.setAccount("123132422124321");
        user.setName("abcde53rfgh");
        user.setPassword("abcdefgh");
        user.setSalt("abcd");
        user.setLocked(0);
        userMapper.insetUser(user);
    }

    @Test
    public void selectUserByName(){
        User user = userMapper.selectUserByName("cjx913");
        assert user!=null;
    }

    @Test
    public void findPermissionsByUserId(){
        List<Permission> permissions = userMapper.selectPermissionsByUserId("0000000");
        assert permissions!=null;
    }

    @Test
    public void selectRolesByUserId(){
        List<Role>  roles = userMapper.selectRolesByUserId("1000000");
        assert roles!=null;
    }

    @Test
    public void selectScoreListPaginationAndSearch(){
        Map<String,Object> map = new HashMap <>();
        map.put("userId","2000001");
        map.put("start",0);
        map.put("size",3);
        map.put("searchText",null);
        map.put("order","asc".toUpperCase());
        List <ScoreList> scoreLists = userMapper.selectScoreListByUserIdPaginationAndSearch(map);
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
        Map<String,Object> map = new HashMap <>();
        map.put("start",0);
        map.put("size",10);
        map.put("searchText",null);
        map.put("order",null);
        List <UserIdentity> userIdentities = userMapper.selectAllUserIdentitiesWithPermissionAndRolesPaginationAndSearch(map);
        assert userIdentities!=null&&userIdentities.size()>0;

        for(UserIdentity userIdentity:userIdentities){
            List <Permission> permissions = userIdentity.getPermissions();
            System.out.println( permissions!=null);
        }

    }

}
