package com.cjx913.es.controller;


import com.cjx913.es.entity.domain.Paper;
import com.cjx913.es.entity.domain.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.swing.BakedArrayList;

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
        for(int i=1;i<=10;i++){
            subjects.add(new Subject("100"+i,"科目"+i,100+i));
        }
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
        for(int i=1;i<=30;i++){
            papers.add(new Paper(subjectId+"-id-"+i,subjectId+"-name-"+i));
        }
        return papers;
    }

    @GetMapping("/{subjectId}/{paperId}")
    public String exam(@PathVariable(name = "subjectId") String subjectId,@PathVariable(name = "paperId") String paperId){
        return "exam";
    }
}
