package com.cjx913.es.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiresRoles(value = {"administrator","admin"},logical = Logical.OR)
public class AdminController {
    @RequestMapping("/toManage")
    public String toManage(){
        return "manage";
    }
}
