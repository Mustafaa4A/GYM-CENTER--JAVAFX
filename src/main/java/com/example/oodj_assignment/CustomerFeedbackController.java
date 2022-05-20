package com.example.oodj_assignment;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class CustomerFeedbackController {
    @FXML
    TextArea txtFeedback;

    @FXML
    Label lblMessage;

    @FXML
    void sendFeedback() throws IOException {
        String customer = Login.getUser()[0]+"-"+Login.getUser()[1];
        String feedbackText = txtFeedback.getText();
        feedbackText = feedbackText.replace("\n", " ").trim();
        String currentDate = String.valueOf(LocalDateTime.now());

        Feedback feedback = new Feedback(customer, feedbackText, currentDate);
        lblMessage.setText(feedback.registerFeedback());
    };

    @FXML
    void back() throws IOException {
        Main main = new Main();
        main.changeScene("customer_dashboard.fxml");
    }
}
