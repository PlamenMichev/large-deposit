package dk.via.largedeposit.view;

import dk.via.largedeposit.viewmodel.LoginViewModel;
import javafx.scene.layout.Region;

public class LoginViewController {
    private LoginViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, LoginViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
    }
}