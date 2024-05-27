package dk.via.largedeposit.view;

import dk.via.largedeposit.viewmodel.ViewModelFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import static dk.via.largedeposit.view.ViewFactory.LOGIN;

/**
 * ViewHandler for the app
 */
public class ViewHandler {
    private final Scene currentScene;
    private Stage primaryStage;
    private final ViewFactory viewFactory;

    /**
     * Constructor
     * @param viewModelFactory the View Model Factory
     */
    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewFactory = new ViewFactory(this, viewModelFactory);
        this.currentScene = new Scene(new Region());
    }

    /**
     * Start method
     * @param primaryStage the primary stage
     */
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.openView(LOGIN);
        // TODO: open relevant initial view
    }

    /**
     * Method used to open the correct view
     * @param id the id of the view
     */
    public void openView(String id) {
        Region root = viewFactory.load(id);
        currentScene.setRoot(root);
        if (root.getUserData() == null) {
            primaryStage.setTitle("");
        } else {
            primaryStage.setTitle(root.getUserData().toString());
        }
        primaryStage.setScene(currentScene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    /**
     * Method used to close the view
     */
    public void closeView() {
        primaryStage.close();
    }
}
