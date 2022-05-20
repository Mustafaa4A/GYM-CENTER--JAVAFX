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

public class TrainersViewController implements Initializable {


    @FXML
    private Button btnBack;

    @FXML
    private TableView<Trainer> tbTrainers;

    @FXML
    private TableColumn<Trainer, String> tcAddress;

    @FXML
    private TableColumn<Trainer, String>  tcGender;

    @FXML
    private TableColumn<Trainer, String>  tcId;

    @FXML
    private TableColumn<Trainer, String>  tcName;

    @FXML
    private TableColumn<Trainer, String>  tcPhone;

    @FXML
    private TableColumn<Trainer, String>  txEmail;

    @FXML
    void back() throws IOException {
        Main main = new Main();
        main.changeScene("admin_reports.fxml");
    }

    ObservableList<Trainer> trainers = FXCollections.observableArrayList();
    void read() throws IOException {
        String[][] data = Trainer.readTrainers();
        for(String[] row:data){
            trainers.add(new Trainer(row[0], row[1], row[2], row[3], row[4], row[5]));
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        tcPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tcAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        txEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        try {
            read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tbTrainers.setItems(trainers);
    }
}
