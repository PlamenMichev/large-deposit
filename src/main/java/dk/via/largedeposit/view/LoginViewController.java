package dk.via.largedeposit.view;

import dk.via.largedeposit.viewmodel.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import static dk.via.largedeposit.view.ViewFactory.OVERVIEW;

public class LoginViewController {
    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;


    private LoginViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, LoginViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
    }

    @FXML
    private void handleLoginButtonAction() {
        String email = emailField.getText();
        String password = passwordField.getText();

        viewHandler.openView(ViewFactory.USERS_LIST);
    }

    @FXML
    private void handleRegisterButtonAction() {
        viewHandler.openView(ViewFactory.REGISTER);
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
    }
}
