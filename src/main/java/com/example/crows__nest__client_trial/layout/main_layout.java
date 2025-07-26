package com.example.crows__nest__client_trial.layout;


import com.example.crows__nest__client_trial.HelloApplication;
import com.example.crows__nest__client_trial.dbms.dbms1_call;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

class place_holder{
    TextField curr_field;
    curr_text _text;
    String ll;
    place_holder(String str,TextField curr_field ,curr_text _text ){
        this._text=_text;
        this.curr_field=curr_field;
        this.ll=str;
    }


    void fire(){
        if(_text.flag==0){
            System.out.println("called ");
            return;
        }
        System.out.println("called 2");

        new dbms1_call().send_to_the_client();
        curr_field.setText(ll);
        _text.flag=0;

    }
}


class curr_text{
    int flag=0;
    String set(String val){
        if(flag==0){
            String curr="";
            curr+=val.charAt(val.length()-1);
            flag=1;
            return curr;
        }
        return val;
    }
}


public class main_layout {


    public static Scene main_layout_sender(Stage  stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("production_optimized.fxml"));
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(fxmlLoader.load(), screenBounds.getWidth()-100,screenBounds.getHeight()-100 );


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
        search_people1.prefWidthProperty().bind(Bindings.multiply(current_chat_option.widthProperty() , 0.8));

        //Search field 2
        TextField write_text= (TextField) scene.getRoot().lookup("#write_text");
        write_text.prefWidthProperty().bind(Bindings.multiply(Main_Content.widthProperty() , 0.7));

        //curr text 1 -- 2

        curr_text text1=new curr_text();
        curr_text text2=new curr_text();

        place_holder place_holder1=new place_holder("Search People ...", search_people1 , text1);
        place_holder place_holder2=new place_holder("Write a Message",write_text, text2);

        search_people1.textProperty().addListener((obs, old_value, new_value)->{ //(ObservableValue<? extends Number> obs, Number oldVal, Number newVal)
            String h=text1.set(new_value);
            search_people1.setText(h);
        });

        write_text.textProperty().addListener((obs, old_value, new_value)->{ //(ObservableValue<? extends Number> obs, Number oldVal, Number newVal)
            String h=text2.set(new_value);
            write_text.setText(h);
        });

        Button cross_button=(Button) scene.getRoot().lookup("#cross_button");
        cross_button.setOnAction(e -> {
            place_holder1.fire();

        });

        Button send_button=(Button) scene.getRoot().lookup("#send_button");
        send_button.setOnAction((e)->{
            place_holder2.fire();
        });

        return scene;

    }

}
