package com.example.oodj_assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class TrainingSession {
    String id;
    String name;
    String start;
    String end;
    double fee;

    public TrainingSession(String name, String start, String end, double fee) throws IOException {
        this.id = generateId();
        this.name = name;
        this.start = start;
        this.end = end;
        this.fee = fee;
    }

    public TrainingSession(String id, String  name, String start, String end, double fee) throws IOException {
        this(name, start, end, fee);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }


    private String generateId() throws IOException {
        String newId = "";
        int lastId = Integer.parseInt(getSession("")[0]);
        if (lastId < 10)
            newId = "00" + (lastId + 1);
        else if (lastId < 100)
            newId = "0" + (lastId + 1);
        return newId;
    }

    public String registerSession() throws IOException {
        String message = "Successfully Added";
        FileWriter file = new FileWriter("training-session.txt", true);
        String data = id + "|" + name + "|" + start + "|" + end + "|" + fee + "\n";
        file.write(data);
        file.close();
        return message;
    }

    public static String[][] readSessions() throws IOException {
        String[][] data = new String[getSize()][9];
        BufferedReader file = new BufferedReader(new FileReader("training-session.txt"));
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

    public static String[] getSession(String id) throws IOException {
        String[] data = new String[8];
        BufferedReader file = new BufferedReader(new FileReader("training-session.txt"));

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
    public static int getSize() throws IOException {
        int size = 0;
        BufferedReader file = new BufferedReader(new FileReader("training-session.txt"));
        String line = file.readLine();
        while (line != null) {
            size++;
            line = file.readLine();
        }
        file.close();
        return size;
    }
}
