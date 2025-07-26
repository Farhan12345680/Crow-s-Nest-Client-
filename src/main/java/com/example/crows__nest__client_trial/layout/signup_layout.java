package com.example.crows__nest__client_trial.layout;

import com.example.crows__nest__client_trial.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;

import java.io.IOException;

public class signup_layout {
    public static Scene signup_sheet() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sign_Up.fxml"));
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(fxmlLoader.load(), screenBounds.getWidth()-100,screenBounds.getHeight()-100 );


        return  scene;
    }
}
