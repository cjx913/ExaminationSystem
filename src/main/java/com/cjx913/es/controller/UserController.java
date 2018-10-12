package com.cjx913.es.controller;

import java.util.*;

import com.cjx913.es.entity.domain.ScoreList;
import com.cjx913.es.entity.domain.UserIdentity;
import com.cjx913.es.entity.persistent.User;
import com.cjx913.es.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/consultScore")
    public String consultScore() {
        return "score_consult";
    }

    @RequestMapping("/getScoreList")
    @ResponseBody
    public Map<String ,Object> getScoreList(HttpSession session, Long start, Long size, String searchtext, String sortorder) {
        String userId = ((UserIdentity) session.getAttribute("user")).getUserId();
        List <ScoreList> scoreList = userService.findScoreListByUserIdPaginationAndSearch(userId, start, size, searchtext, sortorder);
        Integer total = userService.findAllScoreCountByUserIdPaginationAndSearch(userId,searchtext, sortorder);
        Map<String,Object> map = new HashMap <>();
        map.put("rows",scoreList);
        map.put("total",total);
        return map;
    }

}
