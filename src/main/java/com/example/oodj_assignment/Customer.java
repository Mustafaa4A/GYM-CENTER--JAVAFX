package com.example.oodj_assignment;

import java.io.*;
import java.util.Arrays;

public class Customer {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String date;
    private String address;
    private String username;
    private String password;


    public Customer(String name, String gender, String email, String phone, String date, String address, String username, String password) throws IOException {
        this.id = generateId();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.date = date;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public Customer(String id,String name, String email, String phone, String gender, String date, String address, String username, String password) throws IOException {
        this(name, email, phone, gender, date,address,username, password);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public String registerCustomer() throws IOException {
        String message = "Successfully Added";
        FileWriter file = new FileWriter("customer.txt", true);
        String data =id + "|" +name + "|" + gender + "|"+ email + "|"+phone + "|"+date+"|"+address+"|"
                +username+"|"+password+"\n";
        file.write(data);
        file.close();
        return message;
    }

    public static String[] readCustomer(String id) throws IOException{
        String[] data = new String[8];
        BufferedReader file = new BufferedReader(new FileReader("customer.txt"));

        String line = file.readLine();
        while (line != null) {
            if (id.isEmpty())
                data = line.split("\\|");
            else
                if (line.startsWith(id))
                    data = line.split("\\|");
            line = file.readLine();
        }
        file.close();
        return data;
    }

    public static String[][] readCustomers() throws IOException {
        String[][] data = new String[getSize()][9];
        BufferedReader file = new BufferedReader(new FileReader("customer.txt"));
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

    private String generateId() throws IOException {
        String newId = "";
        int lastId = Integer.parseInt(getCustomer("")[0]);
        if (lastId<10)
            newId = "00"+(lastId+1);
        else if (lastId<100)
            newId = "0"+(lastId+1);
        return newId;
    }

    public static String[] getCustomer(String text) throws IOException {
        String[] data = new String[8];
        BufferedReader file = new BufferedReader(new FileReader("customer.txt"));

        String line = file.readLine();
        while (line != null) {
            if (text.isEmpty())
                data = line.split("\\|");
            else
            if (line.contains(text))
                data = line.split("\\|");
            line = file.readLine();
        }
        file.close();
        return data;
    }

    public static double customerBalance(String customer) throws IOException {
        String[] data = new String[8];
        BufferedReader file = new BufferedReader(new FileReader("training-session.txt"));
        double balance = 0.0;
        String line = file.readLine();
        while (line != null) {
            data = line.split("\\|");
            if (data[1].equals(customer))
                balance = Double.parseDouble(data[4]);
            line = file.readLine();
        }
        file.close();
        return balance;
    }

    public static int getSize() throws IOException {
        int size = 0;
        BufferedReader file = new BufferedReader(new FileReader("customer.txt"));
        String line = file.readLine();
        while (line != null) {
            size++;
            line = file.readLine();
        }
        file.close();
        return size;
    }
}