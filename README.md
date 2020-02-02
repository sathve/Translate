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
  
  - `POST` http://localhost:8080/translate/html/{from-language}/{to-language}

  Example
  en - english
  hi - hindi 

  http://localhost:8080/translate/html/en/hi

  Request format: 
  "text" : {fileName}
  ```
  {
    "text": "C:\\Users\\dell\\workspace\\TranslateAPI\\src\\main\\java\\TranslateHtml.html"
  }
  ```
  
  Response format:
  ```
{
    "originalText": "<html>\n <head> \n  <title>My title</title> \n  <meta charset=\"UTF-8\"> \n </head> \n <body> \n  <div id=\"mydiv\">\n   Contents of a div element\n  </div> \n  <div id=\"mydiv1\">\n   Contents of a div1 element\n  </div> \n  <table style=\"width: 100%\"> \n   <tbody>\n    <tr> \n     <th>Firstname</th> \n     <th>Lastname</th> \n     <th>Age</th> \n    </tr> \n    <tr> \n     <td>Jill</td> \n     <td>Smith</td> \n     <td>50</td> \n    </tr> \n    <tr> \n     <td>Eve</td> \n     <td>Jackson</td> \n     <td>94</td> \n    </tr> \n   </tbody>\n  </table>  \n </body>\n</html>",
    "translatedText": "<html>\n <head> \n  <title>मेरा शीर्षक</title> \n  <meta charset=\"UTF-8\"> \n </head> \n <body> \n  <div id=\"mydiv\">\n   एक दिव्य तत्व की सामग्री\n  </div> \n  <div id=\"mydiv1\">\n   एक div1 तत्व की सामग्री\n  </div> \n  <table style=\"width: 100%\"> \n   <tbody>\n    <tr> \n     <th>पहला नाम</th> \n     <th>उपनाम</th> \n     <th>आयु</th> \n    </tr> \n    <tr> \n     <td>जील</td> \n     <td>लोहार</td> \n     <td>50</td> \n    </tr> \n    <tr> \n     <td>ईव</td> \n     <td>जैक्सन</td> \n     <td>94</td> \n    </tr> \n   </tbody>\n  </table>  \n </body>\n</html>"
}
  ```
  
  Steps to run the application:
  
  Run TranslateApplication.java as a java application.
  Your Spring boot Application will now be running on localhost:8080
  