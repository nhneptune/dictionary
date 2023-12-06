package com.dictionary;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.NamedArg;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.web.WebView;


public class SearchController implements Initializable {

  private Stage stage;
  private Scene scene;
  private Parent root;
  @FXML
  private Label searchLabel;
  @FXML
  private Button backButton;
  @FXML
  private Button deleteButton;
  @FXML
  private TextField wordTextField;
  @FXML
  private ListView<Word> wordListView = new ListView<>();
  @FXML
  private WebView meaningWebview;
  @FXML
  private Button pronounceButton;
  private Word selectedWord;

//  private ObservableList<Word> words = FXCollections.observableArrayList();

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    wordListView.setVisible(false);
    wordListView.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldValue, newValue) -> {
          selectedWord = wordListView.getSelectionModel().getSelectedItem();
          meaningWebview.getEngine().loadContent(selectedWord.getHtml());
        }
    );
  }

  public void switchToScene1(ActionEvent event) throws IOException {
    root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void switchToMenuScene(ActionEvent event) throws IOException {
    root = FXMLLoader.load(getClass().getResource("MenuScene.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void typeWord() {
    String word = wordTextField.getText();
    if (word.equals("")) {
      wordListView.setVisible(false);
      wordListView.getItems().clear();
    } else {
      ResultSet rs = QueryDatabase.getInstance().search(word);
      wordListView.setVisible(true);
      wordListView.getItems().clear();
      try {
        while (rs.next()) {
          wordListView.getItems().add(new Word(rs.getString("word"),
              rs.getString("pronounce"), rs.getString("html")));
        }
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public void deleteWord() {
    QueryDatabase.getInstance().delete(selectedWord);
    wordListView.getItems().remove(selectedWord);
  }

  public void unshodListView() {
    if (!wordTextField.isFocused()) {
      wordListView.setVisible(false);
    }
  }
}