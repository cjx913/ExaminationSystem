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
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;

@Service
@Transactional
public class FileServiceImpl implements FileService {

    @Value("${out_word_dir_path}")
    private String outWordDirPath;
    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private CustomWordToPdfUtil customWordToPdfUtil;

    @Override
    public String uploadWordFile(String fileName, InputStream is) throws IOException {

        int index = fileName.lastIndexOf(".");
        String fileNameWithoutSuffix = fileName.substring(0, index);
        String fileSuffixName = fileName.substring(index);
        if (!outWordDirPath.endsWith("/")) {
            outWordDirPath = outWordDirPath + "/";
        }
        if (!Files.exists(Paths.get(outWordDirPath))) {
            Files.createDirectories(Paths.get(outWordDirPath));
        }
        String filePath = outWordDirPath + fileNameWithoutSuffix + "-" + System.currentTimeMillis() + fileSuffixName;
        Files.copy(is, Paths.get(filePath));
        return filePath;
    }

    @Override
    public String wordToPdf(@NotNull final String wordFilePath) throws URISyntaxException, ExecutionException, InterruptedException {
        return customWordToPdfUtil.wordToPdf(wordFilePath);
    }
}
