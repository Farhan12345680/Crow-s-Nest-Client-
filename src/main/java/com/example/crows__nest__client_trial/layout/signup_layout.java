package com.example.crows__nest__client_trial.layout;

import com.example.crows__nest__client_trial.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import com.example.crows__nest__client_trial.profile.Human_profile;
import javafx.stage.Stage;
import com.example.crows__nest__client_trial.dbms.dbms1_call;
import java.io.IOException;



class password{
    public String password_txt;

    password(){
        password_txt="";
    }
}


public class signup_layout {
    public static Scene signup_sheet( Human_profile profile , Scene main_scene , Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sign_Up.fxml"));
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(fxmlLoader.load(), screenBounds.getWidth()-100,screenBounds.getHeight()-100 );

        TextField profile_id_input = (TextField) scene.getRoot().lookup("#signup1");
        TextField profile_password_input= (TextField)scene.getRoot().lookup("#signup2");

        password password_txt= new password();

        profile_password_input.textProperty().addListener((obs, old_value, new_value)->{ //(ObservableValue<? extends Number> obs, Number oldVal, Number newVal)
            char h=new_value.charAt(new_value.length()-1) ;
            password_txt.password_txt+=(""+h);
            String temp="";
            for(int i=0;i<new_value.length(); i++){
                temp+="●";
            }
            profile_password_input.setText(temp);

        });

        Human_profile profile1= new Human_profile();

        Button sign_up= (Button) scene.getRoot().lookup("#Signup");
        sign_up.setOnAction((event)->{
            dbms1_call.initialize_database();
            stage.setScene(main_scene);
            stage.show();
        });

        Button sign_in=(Button)scene.getRoot().lookup("#sign_in");
        sign_in.setOnAction((event)->{
            Thread t = new Thread(new Runnable(){

                @Override
                public void run() {
                    dbms1_call.initialize_database();
                    dbms1_call.getData();

                }
            });
            t.start();
            stage.setScene(main_scene);
            stage.show();
        });

        return  scene;
    }
}
