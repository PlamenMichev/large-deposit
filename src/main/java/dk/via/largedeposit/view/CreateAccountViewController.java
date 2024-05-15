package dk.via.largedeposit.view;

import dk.via.largedeposit.viewmodel.CreateAccountViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Region;

public class CreateAccountViewController {
    @FXML
    private TextField titleField;

    @FXML
    private ChoiceBox<String> currencyChoiceBox;

    @FXML
    private ChoiceBox<String> typeChoiceBox;


    private CreateAccountViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, CreateAccountViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        currencyChoiceBox.setValue("DKK");
        typeChoiceBox.setValue("Debit");
    }

    @FXML private void handleCreateAccountButtonAction() {
        System.out.println("Create account button clicked");
        System.out.println("Title: " + titleField.getText());
        System.out.println("Currency: " + currencyChoiceBox.getValue());
        System.out.println("Type: " + typeChoiceBox.getValue());
        viewHandler.openView(ViewFactory.OVERVIEW);
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
    }
}
