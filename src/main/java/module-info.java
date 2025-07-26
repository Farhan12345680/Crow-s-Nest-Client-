module com.example.crows__nest__client_trial {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.crows__nest__client_trial to javafx.fxml;
    exports com.example.crows__nest__client_trial;
    exports com.example.crows__nest__client_trial.dbms;
    opens com.example.crows__nest__client_trial.dbms to javafx.fxml;
}