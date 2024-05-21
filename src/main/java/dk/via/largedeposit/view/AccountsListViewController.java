package dk.via.largedeposit.view;

import dk.via.largedeposit.model.Account;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.model.enums.Currency;
import dk.via.largedeposit.model.enums.UserRole;
import dk.via.largedeposit.viewmodel.AccountsListViewModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

import java.util.ArrayList;

public class AccountsListViewController {

    @FXML
    private TableView<Account> accountList;

    private AccountsListViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, AccountsListViewModel viewModel, Region root) {
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

        accountList.setItems(FXCollections.observableList(accounts));
    }

    @FXML
    public void handleActivateDeactivateButtonAction() {
        // Retrieve selected user from the table
        Account selectedAccount = accountList.getSelectionModel().getSelectedItem();
        if (selectedAccount != null) {
            System.out.println("Selected user: " + selectedAccount.getNumber());
            // Update the table view
            accountList.refresh();
        }
    }

    @FXML
    public void handleTransactionsButtonAction() {
        viewHandler.openView(ViewFactory.TRANSACTIONS_LIST);
    }

    @FXML
    public void handleUsersListButtonAction() {
        viewHandler.openView(ViewFactory.USERS_LIST);
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
    }
}
