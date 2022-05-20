package com.example.oodj_assignment;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerProfileController implements Initializable{
    @FXML
    private Label lblUser;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;


    @FXML
    void back() throws IOException {
        Main main = new Main();
        main.changeScene("customer_dashboard.fxml");
    }

    public void setData(){
        String[] customer = Login.getUser();
        txtName.setText(customer[1]);
        txtGender.setText(customer[2]);
        txtEmail.setText(customer[3]);
        txtPhone.setText(customer[4]);
        txtDate.setText(customer[5]);
        txtAddress.setText(customer[6]);
        lblUser.setText(customer[7]);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }

}
