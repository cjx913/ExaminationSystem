package com.cjx913.es.service;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;

public interface FileService {
    String uploadWordFile(MultipartFile multipartFile) throws URISyntaxException;
    String wordToPdf(@NotNull final String paperId) throws URISyntaxException;
}
