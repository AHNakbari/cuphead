module com.example.graphic {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires gson;
    requires java.sql;

    opens view to javafx.fxml, gson;
    exports view;
    opens model to javafx.fxml, gson;
    exports model;
    opens controller.transition to javafx.fxml;
    exports controller.transition;
}