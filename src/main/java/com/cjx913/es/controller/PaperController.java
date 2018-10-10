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

    @RequestMapping("get")
    @ResponseBody
    public Map <String, Object> getPaper() {
        Map <String, Object> result = new HashMap <>();
        try {
            Path path = Paths.get("e:", "1.pdf");
            byte[] data = Files.readAllBytes(path);
            String filename = "output.pdf";
            result.put("filename", filename);
            result.put("data", data);
            return result;
        } catch (IOException e) {
            throw new CustomException(e);
        }
    }

    @RequestMapping("/toPaperUpload")
    public String toPaperUpload() {
        return "paper_upload";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String uploadPaper(@RequestParam("upload") MultipartFile multipartFile) throws CustomException {
        String filename = multipartFile.getOriginalFilename();
        if (!filename.endsWith(".docx") && !filename.endsWith(".doc")) {
            return "文件类型错误";
        }
        try {
            final String wordFilePath = fileService.uploadWordFile(multipartFile);
            return wordFilePath != null ? "上传成功" : "上传失败";
        } catch (URISyntaxException | IOException | ExecutionException | InterruptedException e) {
            throw new CustomException(e.getMessage(), e);
        }
    }

}
