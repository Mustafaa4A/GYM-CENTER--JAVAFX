module com.example.oodj_assignment {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.example.oodj_assignment to javafx.fxml;
    exports com.example.oodj_assignment;
}