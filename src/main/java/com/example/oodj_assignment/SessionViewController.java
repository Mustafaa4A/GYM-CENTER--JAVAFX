package com.example.oodj_assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SessionViewController implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private TableView<TrainingSession> tbSession;

    @FXML
    private TableColumn<TrainingSession, String> tcEnd;

    @FXML
    private TableColumn<TrainingSession, String>  tcFee;

    @FXML
    private TableColumn<TrainingSession, String>  tcId;

    @FXML
    private TableColumn<TrainingSession, String>  tcName;

    @FXML
    private TableColumn<TrainingSession, String> tcStart;

    @FXML
    void back() throws IOException {
        Main main = new Main();
        main.changeScene("admin_reports.fxml");
    }

    ObservableList<TrainingSession> sessions = FXCollections.observableArrayList();
    void read() throws IOException {
        String[][] data = TrainingSession.readSessions();
        for(String[] row:data){
            sessions.add(new TrainingSession(row[0], row[1], row[2], row[3], Double.parseDouble(row[4])));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcStart.setCellValueFactory(new PropertyValueFactory<>("start"));
        tcEnd.setCellValueFactory(new PropertyValueFactory<>("end"));
        tcFee.setCellValueFactory(new PropertyValueFactory<>("fee"));

        try {
            read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tbSession.setItems(sessions);
    }
}
