package com.dictionary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MultipleChoiceEnd_Controller extends FunctionController {
    @FXML
    private Label scorePlace;

    public void displayScore (int score, int numberOfQuestions) {
        String result = "Your score is " + score + " out of " + numberOfQuestions;
        scorePlace.setText(result);
    }

    @FXML
    public void playAgain(ActionEvent e) throws  IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AnswerTheQuestions.fxml"));
        root = loader.load();
        MultipleChoice_Controller multipleChoice_controller = loader.getController();
        multipleChoice_controller.setQuestion(e);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
