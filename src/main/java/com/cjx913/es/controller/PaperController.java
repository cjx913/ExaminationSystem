package com.cjx913.es.controller;

import com.cjx913.es.entity.domain.WordUploadFile;
import com.cjx913.es.exception.CustomException;
import com.cjx913.es.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private FileService fileService;

    @RequestMapping("get")
    @ResponseBody
    public Map<String,Object> getPaper(){
        Map<String,Object> result = new HashMap <>();
        try {
            Path path = Paths.get("e:", "1.pdf");
            byte[] data = Files.readAllBytes(path);
            String filename = "output.pdf";
            result.put("filename",filename);
            result.put("data",data);
            return result;
        }catch (IOException e){
            throw new CustomException(e);
        }
    }

    @RequestMapping("/toPaperUpload")
    public String toPaperUpload(){
        return "paper_upload";
    }

    @RequestMapping("/upload")
    public String uploadPaper(@RequestParam("upload") MultipartFile multipartFile){

        try {
//            MultipartFile multipartFile = wordUploadFile.getMultipartFile();
            String name = multipartFile.getName();
            String contentType = multipartFile.getOriginalFilename();
            String fileName = multipartFile.getOriginalFilename();
            File file = new File("e:/ExaminationSystem/word/"+fileName);
            multipartFile.transferTo(file);
        } catch (IOException e) {
            throw new CustomException(e.getMessage(),e);
        }
        return null;
    }

}
