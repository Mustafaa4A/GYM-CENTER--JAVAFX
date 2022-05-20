package com.example.oodj_assignment;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class BookingSessionController {
    @FXML
    private Button btnBack;

    @FXML
    private Button btnRegister;

    @FXML
    private DatePicker date;

    @FXML
    private Label lblMessage;

    @FXML
    private MenuButton mbTrainer;

    @FXML
    private MenuButton mbSession;


    @FXML
    void back() throws IOException {
        Main main = new Main();
        main.changeScene("customer_dashboard.fxml");
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
                try {
                    readSession();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        }
    }

    @FXML
    void readSession() throws IOException {
        mbSession.setText("Choose a session");
        mbSession.getItems().clear();
        String[] sessions = Trainer.getTrainerSessions(mbTrainer.getText());
        for(String session:sessions){
            MenuItem menuItem = new MenuItem(session);
            mbSession.getItems().add(menuItem);
            menuItem.setOnAction(e->{
                mbSession.setText(menuItem.getText());
            });
        }
    }
    @FXML
    void register() throws IOException {
        String customer = Login.getUser()[0]+"-"+Login.getUser()[1];
        String trainer = mbTrainer.getText();
        String session = mbSession.getText();
        String startDate = date.getValue().toString();

        BookingSession booking = new BookingSession(customer, trainer, session, startDate);
        lblMessage.setText(booking.registerSession());

    }
}
