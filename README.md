# Translate

REST APIs to translate for any language to any language.

API end points 
- `POST` http://localhost:8080/translate/{from-language}/{to-language}

  Example
  en - english
  hi - hindi 

  http://localhost:8080/translate/en/hi

  Request format:
  ```
  {
    "text": "How are you?"
  }
  ```
  
  Response format:
  ```
  {
    "originalText": "How are you?",
    "translatedText": "क्या हाल है?"
  }
  ```
  
  Steps to run the application:
  
  Run TranslateApplication.java as a java application.
  Your Spring boot Application will now be running on localhost:8080
  