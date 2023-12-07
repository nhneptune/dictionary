package com.dictionary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController implements Initializable {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;
    private Scene scene1;
    private Scene menuScene;
    private Scene searchScene;
    private Scene multipleChoiceScene;
    private Scene addNewWordScene;
    private Scene apiTranslateScene;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            searchScene = new Scene(FXMLLoader.load(getClass().getResource("SearchScene.fxml")));
            addNewWordScene = new Scene(FXMLLoader.load(getClass().getResource("AddNewWord.fxml")));
            apiTranslateScene = new Scene(FXMLLoader.load(getClass().getResource("APITranslate.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
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

    public void switchToSearchController(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(searchScene);
        stage.show();
    }

    public void switchToMultipleChoice_Controller(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AnswerTheQuestions.fxml"));
        root = loader.load();
        MultipleChoice_Controller multipleChoice_controller = loader.getController();
        multipleChoice_controller.setQuestion(event);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addingNewWord(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(addNewWordScene);
        stage.show();
    }

    public void apiTranslate(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(apiTranslateScene);
        stage.show();
    }
}



