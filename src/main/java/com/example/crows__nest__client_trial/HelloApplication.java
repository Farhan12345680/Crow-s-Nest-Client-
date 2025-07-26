package com.example.crows__nest__client_trial;

import com.example.crows__nest__client_trial.layout.main_layout;
import com.example.crows__nest__client_trial.layout.signup_layout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Crow's Nest");
        stage.setResizable(false);

        Scene Signup_scene=signup_layout.signup_sheet();
        stage.setScene(Signup_scene);
        stage.show();

        Scene main_scene = main_layout.main_layout_sender(stage);

       // stage.setScene(main_scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}