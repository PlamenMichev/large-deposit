package dk.via.largedeposit.view;

import dk.via.largedeposit.viewmodel.RegisterViewModel;
import javafx.scene.layout.Region;

public class RegisterViewController {
    private RegisterViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, RegisterViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
    }
}
