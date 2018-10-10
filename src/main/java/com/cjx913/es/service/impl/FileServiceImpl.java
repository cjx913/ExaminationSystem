package com.cjx913.es.service.impl;

import com.cjx913.es.exception.CustomException;
import com.cjx913.es.mapper.PaperMapper;
import com.cjx913.es.service.FileService;
import com.cjx913.es.utils.CustomWordToPdfUtil;
import com.cjx913.es.utils.WordToPdfUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@Transactional
public class FileServiceImpl implements FileService {
    @Autowired
    private PaperMapper paperMapper;
    @Value("${out_file_dir_path}")
    private String outFileDirPath;

    @Override
    public String uploadWordFile(MultipartFile multipartFile) throws URISyntaxException {
        String filePath = null;
        try {
            String fileName = multipartFile.getOriginalFilename();
            int index = fileName.lastIndexOf(".");
            String fileNameWithoutSuffix = fileName.substring(0, index);
            String fileSuffixName = fileName.substring(index);
            String fileDirPath = outFileDirPath+"word/";
            if(!Files.exists(Paths.get(fileDirPath))){
                Files.createDirectories(Paths.get(fileDirPath));
            }
            filePath = fileDirPath+fileNameWithoutSuffix+"-"+System.currentTimeMillis()+fileSuffixName;
            File file = new File(filePath);
            multipartFile.transferTo(file);

            wordToPdf(filePath);
            try {
                wordToPdf(filePath);
            } catch (URISyntaxException e) {
                throw new CustomException(e.getMessage(),e);
            }

        } catch (IOException e) {
            throw new CustomException(e.getMessage(),e);
        }
        return filePath;
    }

    @Override
    public String wordToPdf(@NotNull final String wordFilePath) throws URISyntaxException {
        return new CustomWordToPdfUtil().wordToPdf(wordFilePath);
    }
}
