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

    /**
     * Initializer
     * @param viewHandler the View Handler
     * @param viewModel the View Model
     * @param root the root
     */
    public void init (ViewHandler viewHandler, RegisterViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        this.viewModel.bindProperties(firstNameField.textProperty(), lastNameField.textProperty(), dobPicker.valueProperty(), addressField.textProperty(), postalCodeField.textProperty(), cityField.textProperty(), phoneField.textProperty(), emailField.textProperty(), passwordField.textProperty(), cprField.textProperty());
    }

    /**
     * Handler
     */
    @FXML
    private void handleRegisterButtonAction() {
        try {
            this.viewModel.register();
            viewHandler.openView(ViewFactory.OVERVIEW);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter
     * @return the root
     */
    public Region getRoot() {
        return root;
    }

    /**
     * Reset
     */
    public void reset() {
        firstNameField.setText("");
        lastNameField.setText("");
        dobPicker.setValue(null);
        addressField.setText("");
        postalCodeField.setText("");
        cityField.setText("");
        phoneField.setText("");
        emailField.setText("");
        passwordField.setText("");
        cprField.setText("");
    }
}
