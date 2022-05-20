package com.example.oodj_assignment;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Arrays;


public class LoginController {
    private String role;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblMessage;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    private MenuButton mbRole;

    @FXML
    private MenuItem miAdmin;

    @FXML
    private MenuItem miCustomer;

    @FXML
    private MenuItem miTrainer;


    @FXML
    void adminSelected(){
        role = "Admin";
        mbRole.setText(role);
    }
    @FXML
    void customerSelected(){
        role = "Customer";
        mbRole.setText(role);
    }
    @FXML
    void trainerSelected(){
        role = "Trainer";
        mbRole.setText(role);
    }

    @FXML
    void login() throws IOException {
        Main main = new Main();
        if (txtUsername.getText().equals("") || txtPassword.getText().equals("")){
            lblMessage.setText("Please Fill the required fields");
        }else{
            String username = txtUsername.getText().trim();
            String password =txtPassword.getText().trim();

            Login login = new Login(username, password);


            switch (role){
                case "Admin":
                    if (login.adminlogin()){
                        main.changeScene("admin_dashboard.fxml");
                    }else{
                        lblMessage.setText("Incorrect username or password..");
                    };
                    break;
                case "Customer":
                    if (login.customerLogin()){
                        main.changeScene("customer_dashboard.fxml");
                    }else
                        lblMessage.setText("Incorrect username or password..");
            }

        }
    }

}
