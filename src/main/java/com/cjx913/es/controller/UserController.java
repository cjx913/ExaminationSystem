package com.cjx913.es.controller;

import java.util.*;

import com.cjx913.es.entity.domain.ExamResult;
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

        List <ExamResult> rows = new ArrayList <>();

        for (int i = start; i <= start + size - 1; i++) {
            rows.add(new ExamResult("id-" + i, "userName-" + i,
                    "subjectName-" + i, "paperName-" + i,
                    new Date(), new Date(), 0 + i));
        }

        Map <String, Object> result = new HashMap <>();
        result.put("total", 100);
        result.put("rows", rows);
        return result;
    }
}
