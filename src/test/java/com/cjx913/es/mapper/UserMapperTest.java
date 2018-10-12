package com.cjx913.es.mapper;


import com.cjx913.es.SpringTest;
import com.cjx913.es.entity.domain.ScoreList;
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
        User user = userMapper.findUserByName("cjx913");
        assert user!=null;
    }

    @Test
    public void findPermissionsByUserId(){
        List<Permission> permissions = userMapper.selectPermissionsByUserId("2000001");
        assert permissions!=null;
    }

    @Test
    public void selectRolesByUserId(){
        List<Role>  roles = userMapper.selectRolesByUserId("2000001");
        assert roles!=null;
    }

    @Test
    public void selectScoreListPaginationAndSearch(){
        Map<String,Object> map = new HashMap <>();
        map.put("userId","2000001");
//        Pagination pagination = new Pagination(1l, 3l, null, "asc");
//        map.put("pagination",pagination);
        map.put("start",0);
        map.put("size",3);
        map.put("searchText",null);
        map.put("order","asc".toUpperCase());
        List <ScoreList> scoreLists = userMapper.selectScoreListPaginationAndSearch(map);
        assert scoreLists!=null&&scoreLists.size()>0;
    }

}
