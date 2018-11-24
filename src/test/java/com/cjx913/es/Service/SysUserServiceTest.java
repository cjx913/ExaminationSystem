package com.cjx913.es.Service;

import com.cjx913.es.SpringTest;
import com.cjx913.es.entity.persistent.SysPermission;
import com.cjx913.es.entity.persistent.SysUser;
import com.cjx913.es.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class SysUserServiceTest extends SpringTest {
    @Autowired
    private UserService userService;

    @Test
    public void saveUser(){
        SysUser sysUser = new SysUser();
        sysUser.setAccount("1231212342243321");
        sysUser.setName("abcdlmn");
        sysUser.setPassword("abcdefgh");
        sysUser.setSalt("abcd");
        sysUser.setLocked(0);
        userService.saveUser(sysUser);
    }

    @Test
    public void findScoreListPaginationAndSearch(){
        List <Map <String, Object>> list = userService.findScoreListByUserIdPaginationAndSearch("2000001", 1l, 4l, "", "");
        assert list!=null&&list.size()>0;
    }

    @Test
    public void findPermissionsByUserId(){
        List<SysPermission> sysPermissions = userService.findPermissionsByUserId("0000000");
        assert sysPermissions !=null;
    }

}
