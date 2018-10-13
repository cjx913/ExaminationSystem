package com.cjx913.es.controller;

import com.cjx913.es.entity.persistent.Paper;
import com.cjx913.es.exception.CustomException;
import com.cjx913.es.service.FileService;
import com.cjx913.es.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private FileService fileService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private TaskExecutor taskExecutor;


    @RequestMapping("/toPaperUpload")
    public String toPaperUpload() {
        return "manage/paper_upload";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String uploadPaper(@RequestParam("upload") MultipartFile multipartFile) throws CustomException {

        try {
            String fileName = multipartFile.getOriginalFilename();
            int index = fileName.lastIndexOf(".");
            String fileNameWithoutSuffix = fileName.substring(0, index);
            String fileSuffixName = fileName.substring(index);
            if (!fileSuffixName.equals(".docx") && !fileSuffixName.equals(".doc")) {
                return "上传失败!文件类型错误";
            }
            String wordFileName = fileNameWithoutSuffix + "-" + System.currentTimeMillis() + fileSuffixName;
            //保存文件
            String wordPath = fileService.uploadWordFile(wordFileName, multipartFile.getInputStream());

            //写到数据库
            Paper paper = new Paper();
            paperService.savePaperWithWordPath(paper,wordPath);

           return "上传成功";
        } catch (IOException e) {
            throw new CustomException("上传失败，系统错误", e);
        }
    }

}
