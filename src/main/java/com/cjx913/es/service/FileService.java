package com.cjx913.es.service;


import com.cjx913.es.entity.persistent.Paper;
import com.cjx913.es.entity.persistent.PaperFile;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

public interface FileService {
    String wordToPdf(@NotNull final String wordFilePath) throws URISyntaxException, ExecutionException, InterruptedException;

    String uploadWordFile(String wordFileName, InputStream inputStream) throws IOException;
}
