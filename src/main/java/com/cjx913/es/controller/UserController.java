package com.cjx913.es.controller;

import java.util.*;

import com.cjx913.es.entity.domain.ScoreList;
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
    public List <ScoreList> getScoreList(HttpSession session, Long start, Long size, String searchtext, String sortorder) {
        String userId = ((User) session.getAttribute("user")).getId();
        List <ScoreList> scoreList = userService.findScoreListPaginationAndSearch(userId, start, size, searchtext, sortorder);
        return scoreList;
    }

}
