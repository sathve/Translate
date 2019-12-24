package org.springframework.boot.spring_boot_starter_web.models;

import java.io.Serializable;

public class TranslationResponse implements Serializable {
    private String originalText;
    private String translatedText;

    public TranslationResponse(String originalText, String translatedText) {
        this.originalText = originalText;
        this.translatedText = translatedText;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
}
