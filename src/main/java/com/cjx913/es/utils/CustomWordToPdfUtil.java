package com.cjx913.es.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;

@Component
public class CustomWordToPdfUtil {
    @Value("${font_path}")
    private String fontPath;

    @Value("${out_pdf_dir_path}")
    private String outPdfDirPath;

    public String wordToPdf(@NotNull final String inFilePath) throws URISyntaxException {
        if (!outPdfDirPath.endsWith("/")) outPdfDirPath = outPdfDirPath + "/";
        if (fontPath.startsWith("/")) fontPath = fontPath.substring(1);
        return new WordToPdfUtil(inFilePath, this.outPdfDirPath, this.getClass().getResource("/").toURI().getPath() + this.fontPath).wordToPdf();
    }

}
