package com.cjx913.es.service;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

public interface FileService {
    String uploadWordFile(MultipartFile multipartFile) throws URISyntaxException, IOException, ExecutionException, InterruptedException;
    String wordToPdf(@NotNull final String wordFilePath) throws URISyntaxException, ExecutionException, InterruptedException;
}
