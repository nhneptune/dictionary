package com.dictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DictionaryApplication extends Application {
  @Override
  public void start(Stage stage) throws IOException {
//    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene1.fxml"));
//    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//    stage.setTitle("Welcome!");
//    stage.setScene(scene);
//    stage.show();
    try {
      Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
      Scene scene = new Scene(root);
      stage.setTitle("DICTIONARY ENG-VIET by Nam-Vu");
      String css = this.getClass().getResource("Scene1.css").toExternalForm();
      scene.getStylesheets().add(css);
      stage.setScene(scene);
      stage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
  }

  public static void main(String[] args) {
     launch();
  }
}

