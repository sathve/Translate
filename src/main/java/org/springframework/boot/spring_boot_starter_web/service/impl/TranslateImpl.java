package org.springframework.boot.spring_boot_starter_web.service.impl;

import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.spring_boot_starter_web.client.GoogleTranslateClient;
import org.springframework.boot.spring_boot_starter_web.models.TranslationResponse;
import org.springframework.boot.spring_boot_starter_web.service.inf.TranslateInf;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class TranslateImpl implements TranslateInf {

    @Autowired
    GoogleTranslateClient googleTranslateClient;

    private final String ROOT_DIR = "/tmp";
    private final String HTML = "html";

    public TranslationResponse translate(String fromLanguage, String toLanguage, String sentence) throws Exception {
        String response = googleTranslateClient.translate(fromLanguage, toLanguage, sentence);
        return new TranslationResponse(sentence, parseResult(response));

    }

    private String uploadToLocalFileSystem(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String filePath = new StringBuffer(ROOT_DIR).append(File.separator).append(fileName).toString(); try {
            Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw e;
        } return filePath;
    }

    private void cleanUp() {
        ExtensionFilter filter = new ExtensionFilter(HTML); File dir = new File(ROOT_DIR);
        String[] list = dir.list(filter);

        if (list.length > 0) {
            for (String file : list) {
                String fileName = new StringBuffer(ROOT_DIR).append(File.separator).append(file).toString();
                new File(fileName).delete();
            }
        }
    }


    public TranslationResponse translateHtml(String fromLanguage, String toLanguage, MultipartFile htmlFile) throws Exception {
        try {
            String filePath = uploadToLocalFileSystem(htmlFile);
            Document doc = Jsoup.parse(new File(filePath), Charset.defaultCharset().name());
            String htmlRequest = doc.toString();

            //to parse head and body elements using JSoup
            Elements els = doc.head().getAllElements(); extractText(fromLanguage, toLanguage, els);

            els = doc.body().getAllElements(); extractText(fromLanguage, toLanguage, els);

            String htmlResponse = doc.toString(); return new TranslationResponse(htmlRequest, htmlResponse);
        } catch (IOException e) {
            throw e;
        } finally {
            cleanUp();
        }
    }

    private void extractText(String fromLanguage, String toLanguage, Elements els) throws Exception {
        //loop for text nodes and translate
        for (Element e : els) {
            List<TextNode> tnList = e.textNodes(); for (TextNode tn : tnList) {
                String original = tn.text();

                if (!original.trim().isEmpty()) {
                    String result = googleTranslateClient.translate(fromLanguage, toLanguage, original);
                    if (result != null) {
                        original = parseResult(result); tn.text(original);
                    }
                }
            }
        }
    }

    private String parseResult(String inputJson) throws Exception {
        JSONArray jsonArray = new JSONArray(inputJson); JSONArray jsonArray2 = (JSONArray) jsonArray.get(0);
        JSONArray jsonArray3 = (JSONArray) jsonArray2.get(0);

        return jsonArray3.get(0).toString();
    }

    public class ExtensionFilter implements FilenameFilter {

        private String ext;

        public ExtensionFilter(String ext) {
            this.ext = ext;
        }

        public boolean accept(File dir, String name) {
            return (name.endsWith(ext));
        }
    }

}
