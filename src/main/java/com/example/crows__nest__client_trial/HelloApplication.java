package com.example.crows__nest__client_trial;

import eu.hansolo.tilesfx.Test;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("production_optimized.fxml"));
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(fxmlLoader.load(), screenBounds.getWidth()-100,screenBounds.getHeight()-100 );
        stage.setTitle("Crow's Nest");

        stage.setResizable(false);

        //parent_hbox(don't touch) #parent_hbox
        HBox global_container=(HBox) scene.getRoot().lookup("#global_container");
        global_container.prefHeightProperty().bind(stage.heightProperty());
        global_container.prefWidthProperty().bind(stage.widthProperty());

        VBox Main_Content=(VBox) scene.getRoot().lookup("#Main_Content");
        Main_Content.prefHeightProperty().bind(global_container.heightProperty());
        Main_Content.prefWidthProperty().bind(Bindings.multiply(global_container.widthProperty() , 0.7));

        VBox current_chat_option=(VBox)scene.getRoot().lookup("#current_chat_option");
        current_chat_option.prefHeightProperty().bind(global_container.heightProperty());
        current_chat_option.prefWidthProperty().bind(Bindings.multiply(global_container.widthProperty() , 0.3));

        // name box
        HBox name_box=(HBox) scene.getRoot().lookup("#name_box");
        name_box.prefWidthProperty().bind(current_chat_option.widthProperty());

        Label Title_Shower=(Label) scene.getRoot().lookup("#Title_Shower");
        Title_Shower.prefWidthProperty().bind(Bindings.multiply(current_chat_option.widthProperty() , 0.85));

        // Search field 1
        TextField search_people1= (TextField) scene.getRoot().lookup("#search_people1");
        search_people1.prefWidthProperty().bind(Bindings.multiply(current_chat_option.widthProperty() , 0.7));

        //Search field 2

        TextField write_text= (TextField) scene.getRoot().lookup("#write_text");
        write_text.prefWidthProperty().bind(Bindings.multiply(Main_Content.widthProperty() , 0.7));


        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello world12");
        launch();
    }
}