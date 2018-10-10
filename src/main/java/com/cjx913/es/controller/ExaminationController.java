package com.cjx913.es.controller;


import com.cjx913.es.entity.persistent.Paper;
import com.cjx913.es.entity.persistent.Subject;
import com.cjx913.es.entity.view.PaperVO;
import com.cjx913.es.exception.CustomException;
import com.cjx913.es.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/exam")
public class ExaminationController {

    @Autowired
    private PaperService paperService;

    @RequestMapping("/start")
    public String start() {
        return "subject_select";
    }

    @GetMapping("/getAllSubjects")
    @ResponseBody
    public List <PaperVO> getAllSubjects() {
        List <PaperVO> subjects = paperService.findAllSubjectsWithPaperCount();
        return subjects;
    }

    @RequestMapping("/selectSubject/{subjectId}")
    public String selectSubject(@ModelAttribute @PathVariable(name = "subjectId") String subjectId) {
        return "paper_select";
    }

    @GetMapping("/getAllPapers/{subjectId}")
    @ResponseBody
    public List <Paper> getAllPapers(@PathVariable(name = "subjectId") String subjectId) {
        List <Paper> papers = paperService.findAllPapersBySubjectId(subjectId);
        return papers;
    }

    @GetMapping("/{subjectId}/{paperId}")
    public String exam(
            @ModelAttribute @PathVariable(name = "subjectId") String subjectId,
            @ModelAttribute @PathVariable(name = "paperId") String paperId) {
        return "exam";
    }

    @RequestMapping("/getPaper/{subjectId}/{paperId}")
    @ResponseBody
    public Map <String, Object> getPaper(@PathVariable(name = "subjectId") String subjectId, @PathVariable(name = "paperId") String paperId) {
        Map <String, Object> result = new HashMap <>();
        try {
            PaperVO paperVO = paperService.findPaperNameAndPdfPathBySubjectIdAndPaperId(subjectId, paperId);
            Path path = Paths.get(paperVO.getPaperPdfPath());
            byte[] data = Files.readAllBytes(path);
            String filename = paperVO.getPaperName()+".pdf";
            result.put("filename", filename);
            result.put("data", data);
            return result;
        } catch (IOException e) {
            throw new CustomException(e);
        }
    }
}
