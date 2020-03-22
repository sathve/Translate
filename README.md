# Translate

REST APIs to translate for any language to any language.

API end points 
- `POST` http://localhost:8080/translate/{from-language}/{to-language}

 ### Sample Request URL 
 `http://localhost:8080/translate/en/hi`

 ### Request:
  ```
  $ curl --location --request POST 'http://localhost:8080/translate/en/hi' --header 'Content-Type: application/json' --data-raw  '{ "text": "How are you?" }'
  ```
  
 ### Sample Response:
  ```
  {
    "originalText": "How are you?",
    "translatedText": "क्या हाल है?"
  }
  ```

 ### Request:
  - `FROM_LANGUAGE` - Source language (Eg. `en` for English)
  - `TO_LANGUAGE`   - Destination language (Eg. `hi` for Hindi)
  - `FILE_LOCATION` - Path to the file
  ```
  $ curl --location --request POST 'http://localhost:8080/translate/html/[FROM_LANGUAGE]/[TO_LANGUAGE]'  --header 'Content-Type: multipart/form-data; boundary=--------------------------757881878258573131885729' --form 'file=[FILE_LOCATION]'
  ```
 ### Sample Request URL
  `http://localhost:8080/translate/html/en/hi`
  
 ### Sample Response:
  ```
  {
    "originalText": "<html>\n <head></head>\n <body>\n  \\n  \\n \n  <title>My title</title> \\n \n  <meta charset=\"\\&quot;UTF-8\\&quot;\"> \\n  \\n  \\n \n  <div id=\"\\&quot;mydiv\\&quot;\">\n   \\n Contents of a div element\\n \n  </div> \\n \n  <div id=\"\\&quot;mydiv1\\&quot;\">\n   \\n Contents of a div1 element\\n \n  </div> \\n \n  <table style=\"\\&quot;width:\" 100%\\\">\n    \\n \n   <tbody>\n    \\n \n    <tr>\n      \\n \n     <th>Firstname</th> \\n \n     <th>Lastname</th> \\n \n     <th>Age</th> \\n \n    </tr> \\n \n    <tr>\n      \\n \n     <td>Jill</td> \\n \n     <td>Smith</td> \\n \n     <td>50</td> \\n \n    </tr> \\n \n    <tr>\n      \\n \n     <td>Eve</td> \\n \n     <td>Jackson</td> \\n \n     <td>94</td> \\n \n    </tr> \\n \n   </tbody>\\n \n  </table> \\n \\n\n </body>\n</html>",
    "translatedText": "<html>\n <head></head>\n <body>\n  \\ n\\ n\n  <title>मेरा शीर्षक</title>\\ n\n  <meta charset=\"\\&quot;UTF-8\\&quot;\">\\ n\\ n\\ n\n  <div id=\"\\&quot;mydiv\\&quot;\">\n   \\ n एक div तत्व के घटक \\ n\n  </div>\\ n\n  <div id=\"\\&quot;mydiv1\\&quot;\">\n   \\ n एक div1 तत्व की सामग्री \\ n\n  </div>\\ n\n  <table style=\"\\&quot;width:\" 100%\\\">\n   \\ n\n   <tbody>\n    \\ n\n    <tr>\n     \\ n\n     <th>पहला नाम</th>\\ n\n     <th>उपनाम</th>\\ n\n     <th>आयु</th>\\ n\n    </tr>\\ n\n    <tr>\n     \\ n\n     <td>जील</td>\\ n\n     <td>लोहार</td>\\ n\n     <td>50</td>\\ n\n    </tr>\\ n\n    <tr>\n     \\ n\n     <td>ईव</td>\\ n\n     <td>जैक्सन</td>\\ n\n     <td>94</td>\\ n\n    </tr>\\ n\n   </tbody>\\ n\n  </table>\\ n\\ n\n </body>\n</html>"
  }
  ```
  
## Run
  
Run `TranslateApplication.java` as a java application.
Your Spring boot Application will now be running on localhost:8080
  
