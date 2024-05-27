package dk.via.largedeposit.server;

import dk.via.largedeposit.database.DatabaseConnector;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

/**
 * Starter for the server
 */
public class ServerApplication {
    public static final String SERVER_OBJECT_NAME = "large-deposit-servers";
    public static int REGISTRY_PORT = 1099;

    /**
     * Main method for the server
     * @param args
     * @throws RemoteException
     * @throws AlreadyBoundException
     * @throws SQLException
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, SQLException {
        var registry = LocateRegistry.createRegistry(REGISTRY_PORT);
        var server = new ServerImplementation();
        registry.bind(SERVER_OBJECT_NAME, UnicastRemoteObject.exportObject(server, 0));
        System.out.println("Server is running...");
    }
}
