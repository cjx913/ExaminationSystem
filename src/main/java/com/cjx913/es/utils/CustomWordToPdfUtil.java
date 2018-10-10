package com.cjx913.es.utils;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class CustomWordToPdfUtil extends WordToPdfUtil {
    private static String FONT_PATH = null;
    private static String OUT_FILE_DIR_PATH = null;

    static {
        try {
            FONT_PATH = CustomWordToPdfUtil.class.getClassLoader().getResource("ttf/simsun.ttf").toURI().getPath();
            OUT_FILE_DIR_PATH = "e:/ExaminationSystem/pdf";
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public CustomWordToPdfUtil(@NotNull String inFilePath, @NotNull String outFileDirPath) throws URISyntaxException {
        super(inFilePath, outFileDirPath, FONT_PATH);
    }

    public CustomWordToPdfUtil(@NotNull String inFilePath) {
        super(inFilePath, OUT_FILE_DIR_PATH, FONT_PATH);
    }

}
