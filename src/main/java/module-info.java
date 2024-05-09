module dk.via {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.rmi;

    opens dk.via.largedeposit.view to javafx.fxml;
    opens dk.via.largedeposit to javafx.fxml;

    exports dk.via.largedeposit;
}