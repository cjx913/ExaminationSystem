package com.cjx913.es.controller;


import com.alibaba.fastjson.JSONObject;
import com.cjx913.es.entity.domain.ExamAnswer;
import com.cjx913.es.exception.CustomException;
import com.cjx913.es.service.ExaminationService;
import com.cjx913.es.service.PaperService;
import com.cjx913.es.service.SubjectClassificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.HashBasedTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/exam")
public class ExaminationController {

    @Autowired
    private SubjectClassificationService subjectClassificationService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private ExaminationService examinationService;

    @RequestMapping("/selectSubject")
    public String selectSubject() {
        return "exam/subject_select";
    }

    @GetMapping("/getAllSubjectsIdAndNamesWithPaperCount")
    @ResponseBody
    public List <Map <String, Object>> getAllSubjectsIdAndNamesWithPaperCount() {
        return subjectClassificationService.findAllSubjectsIdAndNamesWithPaperCount();
    }

    @RequestMapping("/selectPaper/{subjectId}")
    public String selectPaper(@ModelAttribute @PathVariable(name = "subjectId") String subjectId) {
        return "exam/paper_select";
    }

    @GetMapping("/getAllPapersBySubjectId/{subjectId}")
    @ResponseBody
    public List <Map <String, Object>> getAllPapersBySubjectId(@PathVariable(name = "subjectId") String subjectId) {
        return paperService.selectAllPapersIdAndNameBySubjectId(subjectId);
    }

    @GetMapping("/{subjectId}/{paperId}")
    public String exam(
            @ModelAttribute @PathVariable(name = "subjectId") String subjectId,
            @ModelAttribute @PathVariable(name = "paperId") String paperId) {
        return "exam/exam";
    }

    @RequestMapping("/getPaper/{subjectId}/{paperId}")
    @ResponseBody
    public Map <String, Object> getPaper(@PathVariable(name = "subjectId") String subjectId, @PathVariable(name = "paperId") String paperId) {
        Map <String, Object> result = new HashMap <>();
        try {
            Map <String, Object> map = paperService.findPaperNameAndPdfPathBySubjectIdAndPaperId(subjectId, paperId);
            if (map == null) {
                return null;
            }
            Path path = Paths.get((String) map.get("pdfPath"));
            byte[] data = Files.readAllBytes(path);
            String filename = map.get("paperName") + ".pdf";
            result.put("filename", filename);
            result.put("data", data);

            //
            Map <String, Object> message = paperService.findPaperMessageByPaperId(paperId);
            result.put("paperMessage", message);

            return result;
        } catch (IOException e) {
            throw new CustomException(e);
        }
    }


    @PostMapping("/submitAnswer")
    @ResponseBody
    public String submitAnswer(@RequestBody ExamAnswer examAnswer){
        try {
            examinationService.saveExamAnswer(examAnswer);
            return "success";
        } catch (IOException e) {
            throw new CustomException(e);
        }
    }


}
