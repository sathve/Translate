package org.springframework.boot.spring_boot_starter_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.spring_boot_starter_web.service.impl.TranslateImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslateController {

	@Autowired
	TranslateImpl translateService;

	@GetMapping(value = "/translate/{fromLanguage}/{toLanguage}/{sentence}")
	public String getRoomsAvailable(@PathVariable("fromLanguage") final String fromLanguage,
			@PathVariable("toLanguage") final String toLanguage,
			@PathVariable("sentence") final String sentence) throws Exception {
		return this.translateService.translate(fromLanguage, toLanguage, sentence);		
	}
}
