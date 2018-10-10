package com.cjx913.es.utils;

import org.junit.Test;

import java.net.URISyntaxException;

public class WordToPdfUtilsTest {
    @Test
    public void wordToPdf()  {
        String s = null;
        try {
            s = new CustomWordToPdfUtil("e:/1.doc","e:/WEB-INF/file/pdf/").wordToPdf();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
