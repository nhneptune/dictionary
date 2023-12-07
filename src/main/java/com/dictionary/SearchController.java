package com.dictionary;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class SearchController extends FunctionController implements Initializable {

  private Stage stage;
  private Scene scene;
  private Parent root;
  @FXML
  private Label searchLabel;
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

  public void pronounce() {
    System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us"
        + ".cmu_us_kal.KevinVoiceDirectory");
    Voice voice = VoiceManager.getInstance().getVoice("kevin16");
    Voice[] voices = VoiceManager.getInstance().getVoices();
    for (int i = 0; i < voices.length; i++) {
      System.out.println("# Voices: " + voices[i].getName());
    }
    if (voice != null)
    {
      voice.allocate();
      System.out.println("Voice rate: " + voice.getRate());
      System.out.println("Voice pitch: " + voice.getPitch());
      System.out.println("Voice volume: " + voice.getVolume());
      boolean status = voice.speak(selectedWord.getWord());
      System.out.println("Status: " + status);
      voice.deallocate();
    } else {
      System.err.println("Pronounce error!");
    }
  }
}