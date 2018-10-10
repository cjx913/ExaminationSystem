package com.cjx913.es.service.impl;

import com.cjx913.es.exception.CustomException;
import com.cjx913.es.mapper.PaperMapper;
import com.cjx913.es.service.FileService;
import com.cjx913.es.utils.CustomWordToPdfUtil;
import com.cjx913.es.utils.WordToPdfUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Service
@Transactional
public class FileServiceImpl implements FileService {

    @Value("${out_file_dir_path}")
    private String outFileDirPath;
    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private CustomWordToPdfUtil customWordToPdfUtil;

    @Override
    public String uploadWordFile(MultipartFile multipartFile) throws URISyntaxException, IOException, ExecutionException, InterruptedException {

        String fileName = multipartFile.getOriginalFilename();
        int index = fileName.lastIndexOf(".");
        String fileNameWithoutSuffix = fileName.substring(0, index);
        String fileSuffixName = fileName.substring(index);
        String fileDirPath = outFileDirPath + "word/";
        if (!Files.exists(Paths.get(fileDirPath))) {
            Files.createDirectories(Paths.get(fileDirPath));
        }
        String filePath = fileDirPath + fileNameWithoutSuffix + "-" + System.currentTimeMillis() + fileSuffixName;
        File file = new File(filePath);
        multipartFile.transferTo(file);
        return filePath;
    }

    @Override
    public String wordToPdf(@NotNull final String wordFilePath) throws URISyntaxException, ExecutionException, InterruptedException {
        return customWordToPdfUtil.wordToPdf(wordFilePath);
    }
}
