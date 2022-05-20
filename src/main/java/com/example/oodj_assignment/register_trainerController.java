package com.example.oodj_assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class register_trainerController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnRegister;

    @FXML
    private ToggleGroup gender;

    @FXML
    private Label lblMessage;

    @FXML
    private Label lblMessage1;

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
    private TextField txtPhone;


    @FXML
    String getGender() {
        String gender="";
        if (rdFemale.isSelected())
            gender = "Female";
        else if (rdMale.isSelected())
            gender = "Male";

        return gender;
    }

    @FXML
    void register() throws IOException {
        String name = txtName.getText();
        String gender = getGender();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();

        Trainer trainer = new Trainer(name, email, phone, gender, address);
        lblMessage.setText(trainer.registerTrainer());
    }

    @FXML
    void back() throws IOException {
        Main main = new Main();
        main.changeScene("admin_dashboard.fxml");
    }


}
