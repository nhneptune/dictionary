package com.dictionary;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Parent;

public abstract class FunctionController {
  protected Parent root;
  protected Stage stage;
  protected Scene scene;
  @FXML
  protected AnchorPane rootAnchor;
  @FXML
  protected Button backButton;

  public void backToMenuScene() throws IOException {
    root = FXMLLoader.load(getClass().getResource("MenuScene.fxml"));
    stage = (Stage) backButton.getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
}
