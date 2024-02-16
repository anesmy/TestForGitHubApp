package org.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/languages")
@RestController
public class LanguageController {
    @PostMapping()
    public ResponseEntity<String> addLanguage(@RequestParam Language language) {

        if (languageService.addLanguage(language) != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Language added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body("Language has been already added earlier");
        }
    }
}