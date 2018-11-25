package com.cjx913.es.service.impl;

import com.cjx913.es.SpringTest;
import com.cjx913.es.entity.persistent.SysUser;
import com.cjx913.es.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceImplTest extends SpringTest {

    @Autowired
    private UserService userService;
    @Test
    public void findUserByName() {
        SysUser admin = userService.findUserByName("admin");
        assertNotNull(admin);

    }

    @Test
    public void saveUser() {
    }

    @Test
    public void findPermissionsByUserId() {
    }

    @Test
    public void findRolesByUserId() {
    }

    @Test
    public void findScoreListByUserIdPaginationAndSearch() {
    }

    @Test
    public void findAllScoreCountByUserIdPaginationAndSearch() {
    }

    @Test
    public void findAllUserIdentitiesWithPermissionAndRolesPaginationAndSearch() {
    }

    @Test
    public void findAllUserIdentitiesCountSearch() {
    }

    @Test
    public void deleteUserByUserId() {
    }
}