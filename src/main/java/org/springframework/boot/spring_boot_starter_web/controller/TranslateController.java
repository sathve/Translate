package org.springframework.boot.spring_boot_starter_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.spring_boot_starter_web.models.TranslationRequest;
import org.springframework.boot.spring_boot_starter_web.models.TranslationResponse;
import org.springframework.boot.spring_boot_starter_web.service.impl.TranslateImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslateController {

    @Autowired
    TranslateImpl translateService;

    @PostMapping(value = "/translate/{fromLanguage}/{toLanguage}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<TranslationResponse> getRoomsAvailable(@PathVariable("fromLanguage") final String fromLanguage,
                                                                 @PathVariable("toLanguage") final String toLanguage,
                                                                 @RequestBody final TranslationRequest sentence) throws Exception {
        return new ResponseEntity<TranslationResponse>(this.translateService.translate(fromLanguage, toLanguage, sentence.getText()), HttpStatus.OK);
    }
}
