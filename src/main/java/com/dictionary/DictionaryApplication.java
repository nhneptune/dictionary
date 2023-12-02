package com.dictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

public class DictionaryApplication extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("dictionary.fxml"));
    Scene scene = new Scene(root, 320, 240);
    stage.setTitle("Từ điển anh việt");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
     launch();
  }
}
