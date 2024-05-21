package dk.via.largedeposit.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ServerApplication {
    public static final String SERVER_OBJECT_NAME = "large-deposit-servers";
    public static int REGISTRY_PORT = 1099;
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        var registry = LocateRegistry.createRegistry(REGISTRY_PORT);
        var server = new ServerImplementation();
        registry.bind(SERVER_OBJECT_NAME, UnicastRemoteObject.exportObject(server, 0));
        System.out.println("Server is running...");
    }
}
