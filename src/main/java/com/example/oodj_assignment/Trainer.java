package com.example.oodj_assignment;

import java.io.*;
import java.util.Arrays;

public class Trainer {
    private  String id;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String address;


    public Trainer(String name, String gender, String email, String phone, String address) throws IOException {
        this.id = generateId();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
    }

    public Trainer(String id, String name, String gender, String email, String phone, String address) throws IOException {
        this(name, gender, email, phone, address);
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

    public String getAddress() {
        return address;
    }


    public String registerTrainer() throws IOException {
        String message = "Successfully Added";
        FileWriter file = new FileWriter("trainer.txt", true);
        String data = id + "|" + name + "|" + gender + "|" + email + "|" + phone + "|" + address + "\n";
        file.write(data);
        file.close();
        return message;
    }

    public static String[] readTrainer(String id) throws IOException {
        String[] data = new String[8];
        BufferedReader file = new BufferedReader(new FileReader("trainer.txt"));

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

    public static String[][] readTrainers() throws IOException {
        String[][] data = new String[getSize()][9];
        BufferedReader file = new BufferedReader(new FileReader("trainer.txt"));
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
        int lastId = Integer.parseInt(readTrainer("")[0]);
        if (lastId < 10)
            newId = "00" + (lastId + 1);
        else if (lastId < 100)
            newId = "0" + (lastId + 1);
        return newId;
    }

    public static String[] getTrainers() throws IOException {
        String[] data;
        String trainer = "";
        BufferedReader file = new BufferedReader(new FileReader("trainer.txt"));

        String line = file.readLine();
        while (line != null) {
            data = line.split("\\|");
            trainer += data[0]+"-"+data[1]+"|";
            line = file.readLine();
        }
        file.close();
        return trainer.split("\\|");
    }

    public static String[] getTrainerSessions(String trainer) throws IOException {
        String[] data;
        String session = "";
        BufferedReader file = new BufferedReader(new FileReader("training-session.txt"));

        String line = file.readLine();
        while (line != null) {
            data = line.split("\\|");
            if (data[1].equals(trainer))
                session += data[2]+"-"+data[3]+"|";
            line = file.readLine();
        }
        file.close();
        return session.split("\\|");
    }

    public static int getSize() throws IOException {
        int size = 0;
        BufferedReader file = new BufferedReader(new FileReader("trainer.txt"));
        String line = file.readLine();
        while (line != null) {
            size++;
            line = file.readLine();
        }
        file.close();
        return size;
    }
}