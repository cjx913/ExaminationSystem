package com.cjx913.es.controller;

import com.cjx913.es.entity.domain.SubjectClassification;
import com.cjx913.es.entity.domain.UserIdentity;
import com.cjx913.es.service.PaperService;
import com.cjx913.es.service.SubjectClassificationService;
import com.cjx913.es.service.UserService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private SubjectClassificationService subjectClassificationService;
    @Autowired
    private PaperService paperService;

    @RequestMapping("/toManage")
    public String toManage(){
        return "manage/manage";
    }

    @RequestMapping("/userManage")
    public String userManage(){
        return "manage/user_manage";
    }

    @RequestMapping("/paperManage")
    public String paperManage(){
        return "manage/paper_manage";
    }

    @RequestMapping("/user/getAllUserIdentities")
    @ResponseBody
    public Map<String, Object> getAllUsers( Long start, Long size, String searchtext, String sortorder){
        List <Map <String, Object>> maps = userService.findAllUserIdentitiesWithPermissionAndRolesPaginationAndSearch(start, size, searchtext, sortorder);
        Integer total = userService.findAllUserIdentitiesCountSearch(searchtext, sortorder);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",maps);
        map.put("total",total);
        return map;
    }

    @RequestMapping("/user/delete/{userId}")
    public String deleteUser(@PathVariable("userId") String userId){
        Integer i = userService.deleteUserByUserId(userId);
        return "manage/manage";
    }

    @RequestMapping("/subjectManage")
    public String subjectManage(){
        return "manage/subject_manage";
    }

    @RequestMapping("/subject/findAllSubjects")
    @ResponseBody
    public SubjectClassification findAllSubjectClassifications(){
        return subjectClassificationService.findAllSubjectClassifications();
    }


    @RequestMapping("/paper/getAllPapers")
    @ResponseBody
    public Map<String, Object> getAllPapers(Long start, Long size, String searchtext, String sortorder){
        List <Map <String, Object>> maps = paperService.findAllPapersWithExamTimeFullMarkPdfPathWordPath(start, size, searchtext, sortorder);
        Integer total = paperService.findAllPapersWithExamTimeFullMarkPdfPathWordPathCount(searchtext, sortorder);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",maps);
        map.put("total",total);
        return map;
    }
}
