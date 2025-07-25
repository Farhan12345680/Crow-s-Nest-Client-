package com.example.crows__nest__client_trial;

import com.example.crows__nest__client_trial.layout.layout1;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new layout1(stage);
    }

    public static void main(String[] args) {
        System.out.println("Hello world12");
        launch();
    }
}