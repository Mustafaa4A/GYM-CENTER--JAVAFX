package com.example.oodj_assignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Login Page.");
        stage.setScene(scene);
        stage.setResizable(false);;
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    public void changeScene(String fxml) throws IOException{
        Parent page = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        mainStage.getScene().setRoot(page);
    }


}