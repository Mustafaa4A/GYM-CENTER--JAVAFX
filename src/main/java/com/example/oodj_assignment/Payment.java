package com.example.oodj_assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Payment {
    String id;
    String customer;
    double payment;
    String account;
    String description;
    String date;

    public Payment(String customer, double payment, String account, String description, String date) throws IOException {
        this.id = generateId();
        this.customer = customer;
        this.payment = payment;
        this.account = account;
        this.description = description;
        this.date = date;
    }

    public Payment(String id, String customer, double payment, String account, String description, String date) throws IOException {
        this(customer, payment, account, description, date);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public double getPayment() {
        return payment;
    }

    public String getAccount() {
        return account;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    private String generateId() throws IOException {
        String newId = "";
        int lastId = Integer.parseInt(readPayment("")[0]);
        if (lastId < 10)
            newId = "00" + (lastId + 1);
        else if (lastId < 100)
            newId = "0" + (lastId + 1);
        return newId;
    }

    public static String[] readPayment(String id) throws IOException {
        String[] data = new String[8];
        BufferedReader file = new BufferedReader(new FileReader("customer-payment.txt"));

        String line = file.readLine();
        while (line != null) {
            if (id.isEmpty())
                data = line.split("\\|");
            else if (line.startsWith(id))
                data = line.split("\\|");
            line = file.readLine();
        }
        file.close();
        return data;
    }

    public String registerPayment() throws IOException {
        String message = "Payment Process Has Successfully Completed";
        FileWriter file = new FileWriter("customer-payment.txt", true);
        String data = id + "|" + customer + "|" + payment + "|" + account + "|" + description + "|" + date + "\n";
        file.write(data);
        file.close();
        return message;
    }

    public static String[][] readPayments() throws IOException {
        String[][] data = new String[getSize()][9];
        BufferedReader file = new BufferedReader(new FileReader("customer-payment.txt"));
        String line = file.readLine();
        int i = 0;
        while (line != null) {
            data[i] = line.split("\\|");
            line = file.readLine();
            i++;
        }
        file.close();

        return data;
    }

    public static int getSize() throws IOException {
        int size = 0;
        BufferedReader file = new BufferedReader(new FileReader("customer-payment.txt"));
        String line = file.readLine();
        while (line != null) {
            size++;
            line = file.readLine();
        }
        file.close();
        return size;
    }
}
