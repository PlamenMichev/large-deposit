module dk.via {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.rmi;
    requires java.sql;
    requires remoteobserver;
    requires org.postgresql.jdbc;

    opens dk.via.largedeposit.view to javafx.fxml;
    opens dk.via.largedeposit.model to javafx.base;
    opens dk.via.largedeposit to javafx.fxml;
    opens dk.via.largedeposit.client to javafx.fxml;
    opens dk.via.largedeposit.proxy to dk.via.tests;

    exports dk.via.largedeposit;
    exports dk.via.largedeposit.client;
    exports dk.via.largedeposit.server to java.rmi, dk.via.tests;
    exports dk.via.largedeposit.model to dk.via.tests;
    exports dk.via.largedeposit.model.enums to dk.via.tests;
    exports dk.via.largedeposit.view to dk.via.tests;
    exports dk.via.largedeposit.proxy;
    exports dk.via.largedeposit.viewmodel;
}