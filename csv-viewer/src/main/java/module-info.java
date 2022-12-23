module com.csv_viewer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires junit;

    opens com.csv_viewer to javafx.fxml;
    exports com.csv_viewer;

    opens client.controllers to javafx.fxml;
    exports client.controllers;

}