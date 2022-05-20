package com.example.oodj_assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Feedback {
    String customer;
    String feedback;
    String date;

    public Feedback(String customer, String feedback, String date) {
        this.customer = customer;
        this.feedback = feedback;
        this.date = date;
    }


    public String registerFeedback() throws IOException {
        String message = "You Send Your Feedback";
        FileWriter file = new FileWriter("customers-feedback.txt", true);
        String data = customer + "|" + feedback + "|" + date + "\n";
        file.write(data);
        file.close();
        return message;
    }

    public static String[] readFeedbacks() throws IOException {
        String data = "";
        BufferedReader file = new BufferedReader(new FileReader("customers-feedback.txt"));
        String line = file.readLine();
        while (line != null) {
            data += Arrays.toString(line.split("\\|"))+"~";
            line = file.readLine();
        }
        file.close();

        return data.split("~");
    }
}
