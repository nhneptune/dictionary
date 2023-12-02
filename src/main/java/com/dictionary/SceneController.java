package com.dictionary;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
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

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SceneController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Chao Anh Vu!");
    }

    @FXML
    private Label myLabel;

    @FXML
    private TextField myTextField;

    @FXML
    private Button myButton;

    @FXML
    private ListView<String> myListView = new ListView<>();

    int newWord;

    public void translate(ActionEvent event) {
        try {
            newWord = Integer.parseInt(myTextField.getText());
            System.out.println(newWord);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    String[] words = {"apple", "banana", "orange"};

    String currentWord;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        myListView.getItems().addAll(words);
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                currentWord = myListView.getSelectionModel().getSelectedItem();
                myLabel.setText(currentWord);
            }
        });
    }
}



