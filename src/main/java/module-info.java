module org.example.workshopjavafxjdbc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires jdk.compiler;

    opens org.example.workshopjavafxjdbc to javafx.fxml;
    opens org.example.workshopjavafxjdbc.gui to javafx.fxml;

    exports org.example.workshopjavafxjdbc;
    exports org.example.workshopjavafxjdbc.gui;
}
