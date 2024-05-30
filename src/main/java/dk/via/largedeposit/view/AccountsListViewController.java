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

    /**
     * Initializer
     * @param viewHandler the View Handler
     * @param viewModel the View Model
     * @param root the root
     */
    public void init (ViewHandler viewHandler, AccountsListViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        var accounts = new ArrayList<Account>();
        var user = new User(1,"1234123412", "John", "Doe", UserRole.CUSTOMER, "Test address",
                "1234", "City", "93833920", "plamen@mail.dl", "parola123",
                true, 10000, 100000);

        accountList.setItems(FXCollections.observableList(accounts));
    }

    /**
     * Handler
     */
    @FXML
    public void handleActivateDeactivateButtonAction() {
        // Retrieve selected user from the table
        Account selectedAccount = accountList.getSelectionModel().getSelectedItem();
        if (selectedAccount != null) {
            System.out.println("Selected user: " + selectedAccount.getAccountNumber());
            // Update the table view
            accountList.refresh();
        }
    }

    /**
     * Handler
     */
    @FXML
    public void handleTransactionsButtonAction() {
        viewHandler.openView(ViewFactory.TRANSACTIONS_LIST);
    }

    /**
     * Handler
     */
    @FXML
    public void handleUsersListButtonAction() {
        viewHandler.openView(ViewFactory.USERS_LIST);
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
