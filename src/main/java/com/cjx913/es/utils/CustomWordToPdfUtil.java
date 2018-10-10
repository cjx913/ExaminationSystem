package com.cjx913.es.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;

@Component
public class CustomWordToPdfUtil {
    @Value("${font_path}")
    private String fontPath;

    @Value("${out_file_dir_path}")
    private String outFileDirPath;

    public String wordToPdf(@NotNull final String inFilePath) throws URISyntaxException {
        fontPath = CustomWordToPdfUtil.class.getResource(fontPath).toURI().getPath();
        outFileDirPath = outFileDirPath+"pdf/";
        return new WordToPdfUtil(inFilePath,outFileDirPath,fontPath).wordToPdf();
    }

}
