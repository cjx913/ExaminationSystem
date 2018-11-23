package com.cjx913.es.utils;

import com.cjx913.es.SpringTest;
import org.junit.Test;

import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class CustomWordToPdfUtilTest extends SpringTest {

    @Test
    public void wordToPdf() {

        try {
            CustomWordToPdfUtil util = new CustomWordToPdfUtil();
            util.wordToPdf("/home/cjx913/Documents/IdeaProjects/ExaminationSystem/src/main/resources/word/123123.doc");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}