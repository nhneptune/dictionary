package com.dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64.Encoder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.net.URL;
import java.net.URLEncoder;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.net.ssl.HttpsURLConnection;

public class APIController extends FunctionController {
  private Stage stage;
  private Scene scene;
  private Parent root;
  @FXML
  private Button translateButton;
  @FXML
  private TextField inputTextField;
  @FXML
  private TextField outputTextField;
  private String[] userAgents = new String[] {
      "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36", // 13.5%
      "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36", // 6.6%
      "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:94.0) Gecko/20100101 Firefox/94.0", // 6.4%
      "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:95.0) Gecko/20100101 Firefox/95.0", // 6.2%
      "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.93 Safari/537.36", // 5.2%
      "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.55 Safari/537.36" // 4.8%
  };
  public void translate() {
    try {
      String word = inputTextField.getText();
      if (word == null || word.isEmpty()) {
        return;
      }
      URL url = new URL("https://translate.googleapis.com/translate_a/single?client=gtx&sl="
          + "auto&tl=vi&dt=t&ie=UTF-8&oe=UTF-8&otf=1&ssel=0&tsel=0&kc=7&dt=at&dt=bd&dt=ex&dt=ld&dt"
          + "=md&dt=qca&dt=rw&dt=rm&dt=ss&q=" + URLEncoder.encode(word, "UTF-8"));
      HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
      connection.setRequestProperty("User-Agent", userAgents[(int) (Math.random() * userAgents.length)]);
      connection.connect();
      if (connection.getResponseCode() != HttpsURLConnection.HTTP_OK) {
        throw new RuntimeException("HttpResponseCode: " + connection.getResponseCode());
      }
      StringBuilder response = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();

      int start = response.toString().indexOf("\"");
      int end = response.toString().indexOf("\"", start + 1);
      String output = response.toString().substring(start + 1, end);
      outputTextField.setText(output);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    HttpsURLConnection connection = null;
  }
}
