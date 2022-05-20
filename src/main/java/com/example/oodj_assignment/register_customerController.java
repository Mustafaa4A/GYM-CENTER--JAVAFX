package com.example.oodj_assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class register_customerController {

    @FXML
    private Button btnRegister;

    @FXML
    private DatePicker date;

    @FXML
    private RadioButton rdFemale;

    @FXML
    private RadioButton rdMale;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtUsername;

    @FXML
    private Label lblMessage;

    @FXML
    void register(ActionEvent event) throws IOException {
        String name = txtName.getText();
        String gender = getGender();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();
        String pd = String.valueOf(date.getValue());
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        Customer customer = new Customer(name, email, phone, gender, pd, address, username, password);
        lblMessage.setText(customer.registerCustomer());
    }

    @FXML
    String getGender(){
        String gender="";
        if (rdFemale.isSelected())
            gender = "Female";
        else if (rdMale.isSelected())
            gender = "Male";

        return gender;
    }

    @FXML
    void back() throws IOException {
        Main main = new Main();
        main.changeScene("admin_dashboard.fxml");
    }



}
