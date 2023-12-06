package com.dictionary;

import MultipleChoiceGame.MultipleChoice;
import MultipleChoiceGame.QuestionsInGame;
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

public class MultipleChoice_Controller extends SceneController {
    private int numberOfQuestionsUsed = 0;
    private final MultipleChoice multipleChoice = MultipleChoice.getMultipleChoice();
    private String correctedAnswer;

    @FXML
    private Label questionPlace;
    @FXML
    private Label resultPlace;
    @FXML
    private Button button_A;
    @FXML
    private Button button_B;
    @FXML
    private Button button_C;
    @FXML
    private Button button_D;
    @FXML
    private Label scorePlace;

    @FXML
    public void setQuestion(ActionEvent e) throws IOException {
        if (numberOfQuestionsUsed == multipleChoice.getNumberOfQuestions()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultScene.fxml"));
            root = loader.load();
            MultipleChoiceEnd_Controller multipleChoiceEnd_controller = loader.getController();
            multipleChoiceEnd_controller.displayScore(multipleChoice.getScore(), multipleChoice.getNumberOfQuestions());
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            return;
        }
        QuestionsInGame currentQuestions = multipleChoice.returnRandomQuestions();
        questionPlace.setText(currentQuestions.getQuestions());
        button_A.setText(currentQuestions.getAnswer_A());
        button_B.setText(currentQuestions.getAnswer_B());
        button_C.setText(currentQuestions.getAnswer_C());
        button_D.setText(currentQuestions.getAnswer_D());
        correctedAnswer = currentQuestions.getCorrectedAnswer();

        resultPlace.setText("Choose your answer:");
        numberOfQuestionsUsed++;
    }

    public void correct() {
        resultPlace.setText("Well done!");
        multipleChoice.increaseScoreGame();
        scorePlace.setText(multipleChoice.getScore() + "");
    }

    @FXML
    public void pick_A() {
        if (button_A.getText().equals(correctedAnswer)) {
            correct();
        } else {
            resultPlace.setText("Unlucky for you!");
        }
    }

    @FXML
    public void pick_B() {
        if (button_B.getText().equals(correctedAnswer)) {
            correct();
        } else {
            resultPlace.setText("Unlucky for you!");
        }
    }

    @FXML
    public void pick_C() {
        if (button_C.getText().equals(correctedAnswer)) {
            correct();
        } else {
            resultPlace.setText("Unlucky for you!");
        }
    }

    @FXML
    public void pick_D() {
        if (button_D.getText().equals(correctedAnswer)) {
            correct();
        } else {
            resultPlace.setText("Unlucky for you!");
        }
    }

    /** Đưa về scene ban đầu của game. */
    @FXML
    public void switchToGameScene(ActionEvent e) throws  IOException {
        FXMLLoader gameScene = new FXMLLoader(getClass().getResource("gameScene.fxml"));
        root = gameScene.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
