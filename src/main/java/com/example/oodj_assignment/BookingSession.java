package com.example.oodj_assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class BookingSession {
    String customer;
    String trainer;
    String session;
    String startDate;

    public BookingSession(String customer, String trainer, String session, String startDate) {
        this.customer = customer;
        this.trainer = trainer;
        this.session = session;
        this.startDate = startDate;
    }

    public String registerSession() throws IOException {
        String message = "Successfully Added";
        FileWriter file = new FileWriter("booking-session.txt", true);
        String data = customer + "|" + trainer + "|" + session + "|" + startDate + "\n";
        file.write(data);
        file.close();
        return message;
    }


    public static String[][] readBookingSessions() throws IOException {
        String[][] data = new String[getSize()][9];
        BufferedReader file = new BufferedReader(new FileReader("booking-session.txt"));
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
        BufferedReader file = new BufferedReader(new FileReader("booking-session.txt"));
        String line = file.readLine();
        while (line != null) {
            size++;
            line = file.readLine();
        }
        file.close();
        return size;
    }

}
