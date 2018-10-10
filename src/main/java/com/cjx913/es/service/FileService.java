package com.cjx913.es.service;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

public interface FileService {
    String uploadWordFile(String fileName, InputStream os) throws URISyntaxException, IOException, ExecutionException, InterruptedException;
    String wordToPdf(@NotNull final String wordFilePath) throws URISyntaxException, ExecutionException, InterruptedException;
}
