package dk.via.largedeposit.view;

import dk.via.largedeposit.viewmodel.CreateAccountViewModel;
import javafx.scene.layout.Region;

public class CreateAccountViewController {
    private CreateAccountViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, CreateAccountViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
    }
}
