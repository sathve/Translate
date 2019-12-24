package org.springframework.boot.spring_boot_starter_web.service.inf;

import org.springframework.boot.spring_boot_starter_web.models.TranslationResponse;

public interface TranslateInf {

	TranslationResponse translate(String fromLang, String toLang, String sentence) throws Exception;
}
