module name {
    requires javafx.fxml;
    requires transitive javafx.controls;

    opens josh to javafx.fxml;
    exports josh;
}
