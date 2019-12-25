package org.springframework.boot.spring_boot_starter_web.models;

import java.io.Serializable;

public class TranslationRequest implements Serializable {
    private String text;

    public TranslationRequest() {
        super();
    }
    
    public TranslationRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
