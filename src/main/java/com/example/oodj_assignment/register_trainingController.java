package com.example.oodj_assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class register_trainingController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnRegister;

    @FXML
    private Label lblMessage;


    @FXML
    private MenuButton mbTrainer;

    @FXML
    private TextField txtEnd;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtStart;

    @FXML
    void register(ActionEvent event) throws IOException {
        String name = mbTrainer.getText();
        String start = txtStart.getText();
        String end = txtEnd.getText();
        double fee = Double.parseDouble(txtFee.getText());

        TrainingSession trainingSession = new TrainingSession(name, start, end, fee);
        lblMessage.setText(trainingSession.registerSession());

    }

    @FXML
    void readTrainer() throws IOException {
        mbTrainer.getItems().clear();
        String[] trainers = Trainer.getTrainers();
        for (String trainer:trainers) {
            MenuItem menuItem = new MenuItem(trainer);
            mbTrainer.getItems().add(menuItem);
            menuItem.setOnAction(e->{
                mbTrainer.setText(menuItem.getText());
            });
        }
    }

    @FXML
    void back() throws IOException {
        Main main = new Main();
        main.changeScene("admin_dashboard.fxml");
    }




}
