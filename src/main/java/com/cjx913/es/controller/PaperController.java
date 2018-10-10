package com.cjx913.es.controller;

import com.cjx913.es.exception.CustomException;
import com.cjx913.es.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
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
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private FileService fileService;
    @Autowired
    private TaskExecutor taskExecutor;


    @RequestMapping("/toPaperUpload")
    public String toPaperUpload() {
        return "paper_upload";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String uploadPaper(@RequestParam("upload") MultipartFile multipartFile) throws CustomException {

        try {
            String filename = multipartFile.getOriginalFilename();
            if (!filename.endsWith(".docx") && !filename.endsWith(".doc")) {
                return "上传失败!文件类型错误";
            }

            final String wordFilePath = fileService.uploadWordFile(multipartFile.getOriginalFilename(), multipartFile.getInputStream());
            return wordFilePath != null ? "上传成功" : "上传失败";
        } catch (IOException | URISyntaxException | ExecutionException | InterruptedException e) {
            throw new CustomException(e.getMessage(), e);
        }
    }

}
