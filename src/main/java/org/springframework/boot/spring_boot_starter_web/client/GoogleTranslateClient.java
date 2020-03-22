package org.springframework.boot.spring_boot_starter_web.client;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class GoogleTranslateClient {

    private final String BASE_URI = "https://translate.googleapis.com/translate_a/single?";

    public String translate(String fromLanguage, String toLanguage, String sentence) throws IOException {
        String url = new StringBuffer(BASE_URI).append("client=gtx&").append("sl=").append(fromLanguage).append("&tl" +
                "=").append(toLanguage).append("&dt=t&q=").append(URLEncoder.encode(sentence, "UTF-8")).toString();

        URL obj = new URL(url); HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        return response.toString();
    }
}
