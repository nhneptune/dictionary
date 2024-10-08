package com.dictionary;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNewWordController extends FunctionController {
  @FXML
  private Label wordLabel;
  @FXML
  private Label pronounceLabel;
  @FXML
  private Label descriptionLabel;
  @FXML
  private TextField wordTextField;
  @FXML
  private TextField pronounceTextField;
  @FXML
  private TextField descriptionTextField;
  @FXML
  private Button addButton;
  private Word new_Word;
  public void addWord() throws IOException {
    String word = wordTextField.getText();
    String pronounce = pronounceTextField.getText();
    String description = descriptionTextField.getText();
    String html = "<h1>" + word + "</h1><h3><i>/" + pronounce + "/</i></h3><ul><li>"+ description + "</li></ul>";
    new_Word = new Word(word, description, pronounce, html);
    QueryDatabase.getInstance().add(new_Word);
  }
}
