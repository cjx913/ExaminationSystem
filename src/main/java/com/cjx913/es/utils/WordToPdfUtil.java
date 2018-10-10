package com.cjx913.es.utils;

import com.cjx913.es.exception.CustomException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import fr.opensagres.xdocreport.itext.extension.font.AbstractFontRegistry;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.Jsoup;
import org.w3c.dom.Document;

import javax.validation.constraints.NotNull;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WordToPdfUtil {

    private String inFilePath;
    private String inFileNameWithoutSuffix;
    private String inFileName;
    private String inFileSuffixName;

    private long createTime;

    private String picDirPath;
    private String htmlDirPath;

    private String outFileDirPath;
    private String outFileNameWithoutSuffix;
    private String outFileSuffixName = ".pdf";
    private String outFileName;
    private String outFilePath;

    private String fontPath;


    public WordToPdfUtil(@NotNull String inFilePath, @NotNull String outFileDirPath, @NotNull String fontPath) {
        this.inFilePath = inFilePath;
        String[] s = this.inFilePath.split("/");
        this.inFileName = s[s.length - 1];
        int i = this.inFileName.lastIndexOf(".");
        this.inFileNameWithoutSuffix = inFileName.substring(0, i);
        this.inFileSuffixName = inFileName.substring(i);

        if (!this.inFileSuffixName.equals(".docx") && !this.inFileSuffixName.equals(".doc")) {
            throw new FileTypeException("文件类型错误");
        }

        this.createTime = System.currentTimeMillis();

        this.outFileDirPath = outFileDirPath.endsWith("/") ? outFileDirPath : outFileDirPath + "/";
        this.outFileNameWithoutSuffix = this.inFileNameWithoutSuffix + "-" + this.createTime;
        this.outFileName = this.outFileNameWithoutSuffix + this.outFileSuffixName;
        this.outFilePath = this.outFileDirPath + this.outFileName;

        this.picDirPath = this.outFileDirPath + this.outFileNameWithoutSuffix + "/images/";
        this.htmlDirPath = this.outFileDirPath + this.outFileNameWithoutSuffix + "/html/";

        this.fontPath = fontPath;
    }

    public void setFont(String font) {
        this.fontPath = font;
    }

    public String getFont() {
        return this.fontPath;
    }

    private boolean isDocx() {
        if (this.inFileSuffixName.equals(".docx")) {
            return true;
        } else if (this.inFileSuffixName.equals(".doc")) {
            return false;
        } else {
            throw new FileTypeException("文件类型错误");
        }
    }

    /**
     * @return pdf保存的路径
     */
    public String wordToPdf() throws RuntimeException {
        try {
            if (this.isDocx()) {
                return docxToPdf();
            } else {
                return docToPdf();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private String docxToPdf() throws IOException {

        XWPFDocument document = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            is = Files.newInputStream(Paths.get(this.inFilePath));
            if (!Files.exists(Paths.get(this.outFileDirPath))) {
                Files.createDirectories(Paths.get(this.outFileDirPath));
            }
            os = Files.newOutputStream(Paths.get(this.outFilePath));

            document = new XWPFDocument(is);
            PdfOptions options = PdfOptions.create().fontProvider(new AbstractFontRegistry() {
                @Override
                protected String resolveFamilyName(String familyName, int style) {
                    return "simsun";
                }
            });
            PdfConverter.getInstance().convert(document, os, options);
            return this.outFilePath;
        } finally {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
        }
    }

    private String docToPdf() throws IOException, ParserConfigurationException, TransformerException, DocumentException {

        InputStream in = null;
        OutputStream os = null;
        ByteArrayOutputStream baos = null;

        try {
            //创建目录
            if (!Files.exists(Paths.get(this.htmlDirPath))) {
                Files.createDirectories(Paths.get(this.htmlDirPath));
            }
            if (!Files.exists(Paths.get(this.outFileDirPath))) {
                Files.createDirectories(Paths.get(this.outFileDirPath));
            }

            //doc转html
            in = Files.newInputStream(Paths.get(this.inFilePath));
            HWPFDocument hwpfDocument = new HWPFDocument(in);
            WordExtractor wordExtractor = new WordExtractor(hwpfDocument);

            Document htmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(htmlDocument);
            wordToHtmlConverter.setPicturesManager(new PicturesManager() {
                @Override
                public String savePicture(byte[] pic, PictureType pictureType, String suggesteName, float widthInches, float heightInches) {

                    OutputStream os = null;
                    String picPath = null;

                    try {
                        //创建图片目录
                        if (!Files.exists(Paths.get(picDirPath))) {
                            Files.createDirectories(Paths.get(picDirPath));
                        }

                        picPath = picDirPath + outFileNameWithoutSuffix + suggesteName;
                        os = new FileOutputStream(picPath);
                        os.write(pic);
                    } finally {
                        if (os != null) {
                            try {
                                os.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return picPath;
                    }

                }
            });
            wordToHtmlConverter.processDocument(hwpfDocument);

            htmlDocument = wordToHtmlConverter.getDocument();
            DOMSource domSource = new DOMSource(htmlDocument);

            baos = new ByteArrayOutputStream();
            StreamResult streamResult = new StreamResult(baos);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "html");
            transformer.transform(domSource, streamResult);
            //至此，html内容在baos

            //标准化html格式
            String htmlResult = "<!doctype html>" + baos.toString("utf-8");
            org.jsoup.nodes.Document doc = Jsoup.parse(htmlResult, "utf-8");
            doc.outputSettings().syntax(org.jsoup.nodes.Document.OutputSettings.Syntax.xml);
            doc.charset(Charset.forName("utf-8"));
            htmlResult = doc.html();
            //至此，html内容在htmlResult

            //保存为html文件
            String htmlPath = htmlDirPath + outFileNameWithoutSuffix + ".html";
            Files.write(Paths.get(htmlPath), htmlResult.getBytes("utf-8"));


            //html转pdf
            com.itextpdf.text.Document document = new com.itextpdf.text.Document();

            in = Files.newInputStream(Paths.get(htmlPath));
            os = Files.newOutputStream(Paths.get(this.outFilePath));

            PdfWriter pdfWriter = PdfWriter.getInstance(document, os);
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(pdfWriter, document,
                    in, Charset.forName("utf-8"), new SumsimFontPeovider());
            if (document.isOpen()) document.close();

            //删除pic和html目录
            File file = new File(outFileDirPath+outFileNameWithoutSuffix);
            deleteAllFile(file);

            //返回pdf文件路径
            return this.outFilePath;
        } finally {

            if (baos != null) {
                baos.close();
            }

            if (os != null) {
                os.close();
            }

            if (in != null) {
                in.close();
            }
        }
    }

    private void deleteAllFile(File file) {
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    deleteAllFile(subFile);
                }
            }
            file.delete();
        } else {
            file.delete();
        }
    }


    public class SumsimFontPeovider extends XMLWorkerFontProvider {

        private BaseFont baseFont;

        {
            try {
                //String ttf = WordToPdfUtil.class.getClassLoader().getResource("").toURI().getPath() + "ttf/simsun.ttf";
                baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public Font getFont(String fontname, String encoding, boolean embedded, float size, int style, BaseColor color) {

            return new Font(baseFont, size, style, color);
        }
    }


    public class FileTypeException extends RuntimeException {
        public FileTypeException() {
        }

        public FileTypeException(String message) {
            super(message);
        }

        public FileTypeException(String message, Throwable cause) {
            super(message, cause);
        }

        public FileTypeException(Throwable cause) {
            super(cause);
        }

        public FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}


