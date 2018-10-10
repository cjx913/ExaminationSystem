package com.cjx913.es.service.impl;

import com.cjx913.es.mapper.PaperMapper;
import com.cjx913.es.service.FileService;
import com.cjx913.es.utils.CustomWordToPdfUtil;
import com.cjx913.es.utils.WordToPdfUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.net.URISyntaxException;

@Service
@Transactional
public class FileServiceImpl implements FileService {
    @Autowired
    private PaperMapper paperMapper;

    @Override
    public String wordToPdf(@NotNull final String wordFilePath) throws URISyntaxException {
        return new CustomWordToPdfUtil(wordFilePath).wordToPdf();
    }
}
