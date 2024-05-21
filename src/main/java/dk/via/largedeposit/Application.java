package dk.via.largedeposit;

import dk.via.largedeposit.client.Client;
import dk.via.largedeposit.client.ClientImplementation;
import dk.via.largedeposit.database.DatabaseConnector;
import dk.via.largedeposit.model.ModelManager;
import dk.via.largedeposit.proxy.RoleAccessorProxy;
import dk.via.largedeposit.server.Server;
import dk.via.largedeposit.server.ServerApplication;
import dk.via.largedeposit.view.ViewHandler;
import dk.via.largedeposit.viewmodel.ViewModelFactory;
import javafx.stage.Stage;

import java.rmi.registry.LocateRegistry;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Server server = (Server) LocateRegistry.getRegistry(ServerApplication.REGISTRY_PORT).lookup(ServerApplication.SERVER_OBJECT_NAME);
        var client = new ClientImplementation(server);
        var model = new ModelManager(client);
        var modelManagerProxy = new RoleAccessorProxy(model);
        var viewModelFactory = new ViewModelFactory(modelManagerProxy);
        var viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}