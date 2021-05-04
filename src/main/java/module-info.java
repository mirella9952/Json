module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.json;
    requires java.sql;
    requires ojdbc8;
    requires java.naming;

    opens org.example to javafx.fxml;
    exports org.example;
}