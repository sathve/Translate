package org.springframework.boot.spring_boot_starter_web.service.impl;

import org.json.JSONArray;
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

    private String parseResult(String inputJson) throws Exception {
        JSONArray jsonArray = new JSONArray(inputJson);
        JSONArray jsonArray2 = (JSONArray) jsonArray.get(0);
        JSONArray jsonArray3 = (JSONArray) jsonArray2.get(0);

        return jsonArray3.get(0).toString();
    }

}
