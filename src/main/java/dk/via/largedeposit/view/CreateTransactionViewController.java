package dk.via.largedeposit.view;

import dk.via.largedeposit.model.Account;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.model.enums.Currency;
import dk.via.largedeposit.model.enums.UserRole;
import dk.via.largedeposit.viewmodel.CreateTransactionViewModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.util.ArrayList;

public class CreateTransactionViewController {

    @FXML
    private TextField descriptionField;

    @FXML
    private ChoiceBox<Account> fromAccountChoiceBox;

    @FXML
    private TextField receiverAccountNumberField;

    @FXML
    private TextField receiverRegistrationNumberField;

    @FXML
    private TextField amountField;


    private CreateTransactionViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    /**
     * Initializer
     * @param viewHandler the View Handler
     * @param viewModel the View Model
     * @param root the root
     */
    public void init (ViewHandler viewHandler, CreateTransactionViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;


        var accounts = new ArrayList<Account>();
        var user = new User("1234123412", "John", "Doe", UserRole.CUSTOMER, "Test address",
                "1234", "City", "93833920", "plamen@mail.dl", "parola123",
                true, 10000, 100000);
        accounts.add(new Account("12341234", "Second account", user,
                "812491235", 122, Currency.DKK, true, 0, 100000));
        accounts.add(new Account("1235234", "Krona money", user,
                "71239485", 51122, Currency.DKK, true, 0, 100000));
        accounts.add(new Account("6432523423", "Euro account", user,
                "582343825", 10000, Currency.EUR, true, 0, 100000));
        accounts.add(new Account("6123421", "USD account", user,
                "82346901248", 5222, Currency.USD, true, 0, 100000));
        accounts.add(new Account("1234567890", "My account", user,
                "123142421", 0, Currency.DKK, false, 0, 100000));

        fromAccountChoiceBox.setItems(FXCollections.observableList(accounts));
    }

    /**
     * Handler
     */
    @FXML
    private void handleSubmitButtonAction() {
        System.out.println("Submit button clicked");
    }

    /**
     * Handler
     */
    @FXML
    private void handleBackButtonAction() {
        viewHandler.openView(ViewFactory.OVERVIEW);
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
    }
}
