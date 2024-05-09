package dk.via.largedeposit;

import dk.via.largedeposit.model.ModelManager;
import dk.via.largedeposit.view.ViewHandler;
import dk.via.largedeposit.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.rmi.registry.LocateRegistry;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        var model = new ModelManager();
        var viewModelFactory = new ViewModelFactory(model);
        var viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}