package dk.via.largedeposit.view;

import dk.via.largedeposit.viewmodel.RegisterViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class RegisterViewController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private DatePicker dobPicker;

    @FXML
    private TextField addressField;

    @FXML
    private TextField postalCodeField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField cprField;

    private RegisterViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, RegisterViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        this.viewModel.bindProperties(firstNameField.textProperty(), lastNameField.textProperty(), dobPicker.valueProperty(), addressField.textProperty(), postalCodeField.textProperty(), cityField.textProperty(), phoneField.textProperty(), emailField.textProperty(), passwordField.textProperty(), cprField.textProperty());
    }

    @FXML
    private void handleRegisterButtonAction() {
        try {
            this.viewModel.register();
            viewHandler.openView(ViewFactory.OVERVIEW);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
    }
}
