package com.cjx913.es.service.impl;

import com.cjx913.es.service.FileService;
import com.cjx913.es.utils.CustomWordToPdfUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
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
    private CustomWordToPdfUtil customWordToPdfUtil;

    @Override
    public String uploadWordFile(String wordFileName, InputStream is) throws IOException {
        if (!outWordDirPath.endsWith("/")) {
            outWordDirPath = outWordDirPath + "/";
        }
        if (!Files.exists(Paths.get(outWordDirPath))) {
            Files.createDirectories(Paths.get(outWordDirPath));
        }
        String wordPath = outWordDirPath +wordFileName;
        Files.copy(is, Paths.get(wordPath));
        return wordPath;
    }

    @Override
    public String wordToPdf(@NotNull final String wordFilePath) throws URISyntaxException, ExecutionException, InterruptedException {
        return customWordToPdfUtil.wordToPdf(wordFilePath);
    }
}
