package com.example.oodj_assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class admin_dashboardController {

    @FXML
    private Button btnBooking;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnTrainer;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnReports;

    @FXML
    void AddSession(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("register_training.fxml");
    }


    @FXML
    void logout() throws IOException {
        Main main = new Main();
        main.changeScene("login.fxml");
    }

    @FXML
    void registerTrainer() throws IOException {
        Main main = new Main();
        main.changeScene("register_trainer.fxml");
    }

    @FXML
    void registerCustomer() throws IOException {
        Main main = new Main();
        main.changeScene("register_customer.fxml");
    }

    @FXML
    void reports(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("admin_reports.fxml");
    }


}
