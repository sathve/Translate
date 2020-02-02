package org.springframework.boot.spring_boot_starter_web.service.impl;

import java.io.File;
import java.util.List;
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

@Service
public class TranslateImpl implements TranslateInf {

    @Autowired
    GoogleTranslateClient googleTranslateClient;

    public TranslationResponse translate(String fromLanguage, String toLanguage, String sentence) throws Exception {
        String response = googleTranslateClient.translate(fromLanguage, toLanguage, sentence);
        return new TranslationResponse(sentence, parseResult(response));

    }
    
    public TranslationResponse translateHtml(String fromLanguage, String toLanguage, String htmlFile) throws Exception {
    	Document doc = Jsoup.parse(new File(htmlFile), "utf-8"); 
    	String htmlRequest = doc.toString();
    	//to parse head and body elements using JSoup
    	Elements els = doc.head().getAllElements();
    	extractText(fromLanguage, toLanguage, els);

    	els = doc.body().getAllElements();
    	extractText(fromLanguage, toLanguage, els);

    	String htmlResponse = doc.toString();
    	return new TranslationResponse(htmlRequest, htmlResponse);

    }
  
    private void extractText(String fromLanguage, String toLanguage, Elements els) throws Exception {
    	//loop for text nodes and translate
    	for (Element e : els) {
    		List<TextNode> tnList = e.textNodes();
    		for (TextNode tn : tnList){
    			String orig = tn.text();

    			if(!orig.equals(" ")) {
    				String result = googleTranslateClient.translate(fromLanguage,toLanguage,orig);
    				if( result != null) {
    					orig = parseResult(result);
    					tn.text(orig); 
    				}
    			}
    		}
    	}
    }

	private String parseResult(String inputJson) throws Exception {
        JSONArray jsonArray = new JSONArray(inputJson);
        JSONArray jsonArray2 = (JSONArray) jsonArray.get(0);
        JSONArray jsonArray3 = (JSONArray) jsonArray2.get(0);

        return jsonArray3.get(0).toString();
    }

}
