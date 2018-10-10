package com.cjx913.es.controller;

import java.util.*;

import com.cjx913.es.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
    public Map <String, Object> getScoreList(Integer start, Integer size,String searchtext,String sortorder) {

        return null;
    }
}
