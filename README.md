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

