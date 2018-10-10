package com.cjx913.es.controller;


import com.cjx913.es.entity.persistent.Paper;
import com.cjx913.es.entity.persistent.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExaminationController {
    @RequestMapping("/selectSubject")
    public String selectSubject() {
        return "subject_select";
    }

    @GetMapping("/getAllSubject")
    @ResponseBody
    public List<Subject> getAllSubject(){
        List<Subject> subjects = new ArrayList <>();

        return subjects;
    }

    @RequestMapping("/selectPaper/{subjectId}")
    public String selectPaper(@PathVariable(name = "subjectId") String subjectId){

        return "paper_select";
    }

    @GetMapping("/getPapers/{subjectId}")
    @ResponseBody
    public List<Paper> getPapers(@PathVariable(name = "subjectId") String subjectId){
        List<Paper> papers = new ArrayList <>();

        return papers;
    }

    @GetMapping("/{subjectId}/{paperId}")
    public String exam(@PathVariable(name = "subjectId") String subjectId,@PathVariable(name = "paperId") String paperId){
        return "exam";
    }
}
