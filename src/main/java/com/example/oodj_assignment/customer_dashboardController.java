package com.example.oodj_assignment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class customer_dashboardController {

    @FXML
    private Button btnBook;

    @FXML
    private Button btnFeedback;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnPayment;

    @FXML
    private Button btnProfile;


    @FXML
    void logout() throws IOException {
        Main main = new Main();
        main.changeScene("login.fxml");
    }

    @FXML
    void viewProfile() throws IOException {
        Main main = new Main();
        main.changeScene("customer_profile.fxml");
    }

    @FXML
    void bookSession() throws IOException {
        Main main = new Main();
        main.changeScene("booking_session.fxml");
    }


    @FXML
    void viewFeedback() throws IOException {
        Main main = new Main();
        main.changeScene("customer_feedback.fxml");
    }

    @FXML
    void makePayment() throws IOException {
        Main main = new Main();
        main.changeScene("customer_payment.fxml");
    }

}
