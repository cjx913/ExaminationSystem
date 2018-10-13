package com.cjx913.es.controller;

import com.cjx913.es.entity.domain.UserIdentity;
import com.cjx913.es.entity.persistent.User;
import com.cjx913.es.service.UserService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
@RequiresRoles(value = {"administrator","admin"},logical = Logical.OR)
public class AdminController {
    @Autowired
    private UserService userService;

    @RequestMapping("/toManage")
    public String toManage(){
        return "manage/manage";
    }

    @RequestMapping("/userManage")
    public String userManage(){
        return "manage/user_manage";
    }

    @RequestMapping("/getAllUserIdentities")
    @ResponseBody
    public Map<String, Object> getAllUsers( Long start, Long size, String searchtext, String sortorder){
        List<UserIdentity> userIdentities = userService.findAllUserIdentitiesWithPermissionAndRolesPaginationAndSearch(start,size,searchtext,sortorder);
        Integer total = userService.findAllUserIdentitiesCountSearch(searchtext, sortorder);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",userIdentities);
        map.put("total",total);
        return map;
    }
}
