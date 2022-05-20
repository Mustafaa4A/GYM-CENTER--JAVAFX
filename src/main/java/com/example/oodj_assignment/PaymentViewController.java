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

public class PaymentViewController implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private TableView<Payment> tbPayment;

    @FXML
    private TableColumn<Payment, String> tcAccount;

    @FXML
    private TableColumn<Payment, Double> tcAmount;

    @FXML
    private TableColumn<Payment, String> tcDate;

    @FXML
    private TableColumn<Payment, String> tcDescription;

    @FXML
    private TableColumn<Payment, String> tcId;

    @FXML
    private TableColumn<Payment, String> tcName;

    @FXML
    void back() throws IOException {
        Main main = new Main();
        main.changeScene("admin_reports.fxml");
    }

    ObservableList<Payment> payments = FXCollections.observableArrayList();
    void read() throws IOException {
        String[][] data = Payment.readPayments();
        for(String[] row:data){
            payments.add(new Payment(row[0], row[1], Double.parseDouble(row[2]), row[3], row[4], row[5]));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("customer"));
        tcAmount.setCellValueFactory(new PropertyValueFactory<>("payment"));
        tcAccount.setCellValueFactory(new PropertyValueFactory<>("account"));
        tcDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tcDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        try {
            read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tbPayment.setItems(payments);
    }
}
