package com.dictionary;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
  private Label myLabel;

  @FXML
  private TextField myTextField;

  @FXML
  private ListView<Word> myListView = new ListView<>();

  @FXML
  private WebView myWebview;

  private Word selectedWord;

  private ObservableList<Word> words = FXCollections.observableArrayList();

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    myListView.setVisible(false);
    myListView.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldValue, newValue) -> {
          System.out.println("fuck you");
          myWebview.getEngine().loadContent(myListView.getSelectionModel().getSelectedItem().getHtml());
        }
    );
  }

  public void switchToScene1(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

  }

  public void switchToScene2(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("search.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }


  public void typeWord() {
    String word = myTextField.getText();
    if (word.equals("")) {
      myListView.setVisible(false);
      myListView.getItems().clear();
    } else {
      ResultSet rs = this.search();
      myListView.setVisible(true);
      myListView.getItems().clear();
      try {
        while (rs.next()) {
          myListView.getItems()
              .add(new Word(rs.getString("word"), rs.getString("pronounce"), rs.getString("html")));
        }
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public Connection initConnection() {
    String url = "jdbc:sqlite:C:\\Users\\admin\\IdeaProjects\\dictionary\\dict_hh.db";
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url);
      if (conn == null) {
        System.out.println("Khong the ket noi toi database");
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return conn;
  }

  public ResultSet search() {
    String sql =
        "SELECT * FROM av WHERE word LIKE" + "'" + myTextField.getText() + "%'" + "LIMIT 10";
    try {
      Connection conn = this.initConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      return rs;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  public void showSearchResult() {
    String sql = "SELECT * FROM av WHERE word = " + "'" + selectedWord + "'";
    try {
      Connection conn = this.initConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {

      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

//  public void selectWord(MouseEvent mouseEvent) {
//    selectedWord = myListView.getFocusModel().getFocusedItem();
//    myTextField.setText(selectedWord);
//    myListView.setVisible(false);
//    myListView.getItems().clear();
//  }
}