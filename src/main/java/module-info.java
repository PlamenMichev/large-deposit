module dk.via {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.rmi;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires remoteobserver;

    opens dk.via.largedeposit.view to javafx.fxml;
    opens dk.via.largedeposit.model to javafx.base;
    opens dk.via.largedeposit to javafx.fxml;

    exports dk.via.largedeposit;
    exports dk.via.largedeposit.client;
    exports dk.via.largedeposit.server to java.rmi;
    opens dk.via.largedeposit.client to javafx.fxml;
}