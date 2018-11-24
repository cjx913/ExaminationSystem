package com.cjx913.es.mapper;

import com.cjx913.es.SpringTest;
import com.cjx913.es.entity.domain.UserIdentity;
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
    }

    @Test
    public void selectRolesByUserId() {
    }

    @Test
    public void selectScoreListByUserIdPaginationAndSearch() {
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
        List <Map <String, Object>> maps = userMapper.selectScoreListByUserIdPaginationAndSearch(map);
        assert maps!=null;
    }

    @Test
    public void selectAllUserIdentitiesCountSearch() {
    }
}