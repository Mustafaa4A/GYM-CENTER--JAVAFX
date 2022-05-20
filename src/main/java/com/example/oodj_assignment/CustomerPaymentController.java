package com.example.oodj_assignment;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDateTime;

public class CustomerPaymentController {

    @FXML
    private Label lblMessage;

    @FXML
    private TextField txtAccount;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtPayment;


    @FXML
    void makePayment() throws IOException {
        String customer = Login.getUser()[0]+"-"+Login.getUser()[1];
        String paymentFee = txtPayment.getText().replace("\n", "");
        String account = txtAccount.getText();
        String description = txtDescription.getText();
        String date = String.valueOf(LocalDateTime.now());

        Payment payment = new Payment(customer, Double.parseDouble(paymentFee), account, description, date);
        lblMessage.setText(payment.registerPayment());
    }

    @FXML
    void back() throws IOException {
        Main main = new Main();
        main.changeScene("customer_dashboard.fxml");
    }
}
