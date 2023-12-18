module com.caloriescounter.tubes {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.caloriescounter.tubes to javafx.fxml;
    exports com.caloriescounter.tubes;
}