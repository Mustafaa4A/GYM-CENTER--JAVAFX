package com.example.oodj_assignment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AdminReportsController {
    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnPayments;

    @FXML
    private Button btnSessions;

    @FXML
    private Button btnTrainer;

    @FXML
    void viewCustomers() throws IOException{
        Main main = new Main();
        main.changeScene("customers_view.fxml");
    }

    @FXML
    void viewTrainers() throws IOException{
        Main main = new Main();
        main.changeScene("trainers_view.fxml");
    }

    @FXML
    void viewSession() throws IOException{
        Main main = new Main();
        main.changeScene("sessions_view.fxml");
    }

    @FXML
    void viewPayment() throws IOException {
        Main main = new Main();
        main.changeScene("payments_view.fxml");
    }

    @FXML
    void back() throws IOException {
        Main main = new Main();
        main.changeScene("admin_dashboard.fxml");
    }
}
