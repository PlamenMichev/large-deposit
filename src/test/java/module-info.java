module dk.via.tests {
    requires dk.via;
    requires org.junit.jupiter.api;
    requires java.rmi;
    requires org.mockito.junit.jupiter;
    requires org.mockito;
    requires javafx.base;  // if you're using Mockito

    exports dk.via to org.junit.platform.commons;
    opens dk.via to org.junit.platform.commons;
}