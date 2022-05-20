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
import java.util.Arrays;
import java.util.ResourceBundle;

public class CustomersViewController implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private TableView<Customer> tbCustomer;

    @FXML
    private TableColumn<Customer, String> tcAddress;

    @FXML
    private TableColumn<Customer, String>  tcDate;

    @FXML
    private TableColumn<Customer, String>  tcGender;

    @FXML
    private TableColumn<Customer, String>  tcId;

    @FXML
    private TableColumn<Customer, String>  tcName;

    @FXML
    private TableColumn<Customer, String> tcPhone;

    @FXML
    private TableColumn<Customer, String>  tcUser;

    @FXML
    private TableColumn<Customer, String>  txEmail;




    @FXML
    void back() throws IOException {
        Main main = new Main();
        main.changeScene("admin_reports.fxml");
    }


    ObservableList<Customer> customers = FXCollections.observableArrayList();
    void read() throws IOException {
      String[][] data = Customer.readCustomers();
      for(String[] row:data){
          customers.add(new Customer(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8]));
      }
   }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        tcPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tcAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tcDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tcUser.setCellValueFactory(new PropertyValueFactory<>("username"));
        txEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        try {
            read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tbCustomer.setItems(customers);
    }
}
