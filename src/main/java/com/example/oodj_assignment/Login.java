package com.example.oodj_assignment;

import java.io.IOException;
import java.util.Arrays;

public class Login {
    private String username;
    private String password;
    private static String[] user;

    public static void main(String[] args) throws IOException {
        Login login = new Login("ali","123");
        login.customerLogin();
        System.out.println(Arrays.toString(Login.getUser()));
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String[] getUser() {
        return user;
    }

    public static void setUser(String[] user) {
        Login.user = user;
    }

    public boolean adminlogin(){
        return this.username.equals("admin") && this.password.equals("admin");
    }

    public boolean customerLogin() throws IOException {
        boolean isLogin = false;
        String[] user = Customer.getCustomer(username);
        setUser(user);
        if (user[7].equals(username) && user[8].equals(password)){
            isLogin = true;
        }
        return isLogin;
    }


}