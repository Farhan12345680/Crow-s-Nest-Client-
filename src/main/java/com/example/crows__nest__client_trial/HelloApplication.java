package com.example.crows__nest__client_trial;

import com.example.crows__nest__client_trial.layout.main_layout;
import com.example.crows__nest__client_trial.layout.signup_layout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import com.example.crows__nest__client_trial.profile.Human_profile;



public class HelloApplication extends Application {
    AtomicBoolean  filled;
    @Override
    public void start(Stage stage ) throws IOException {
        filled = new AtomicBoolean(false);
        stage.setTitle("Crow's Nest");
        stage.setResizable(false);
        Human_profile current_human=new Human_profile();

        Scene main_scene = main_layout.main_layout_sender(stage);

        Scene Signup_scene=signup_layout.signup_sheet(filled,current_human ,main_scene ,stage );
        stage.setScene(Signup_scene);
        stage.show();


//
//
//        stage.setScene(main_scene);
//        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}