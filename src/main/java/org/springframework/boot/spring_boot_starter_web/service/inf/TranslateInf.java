package org.springframework.boot.spring_boot_starter_web.service.inf;

public interface TranslateInf {

	String translate(String fromLang, String toLang, String sentence) throws Exception;
}
