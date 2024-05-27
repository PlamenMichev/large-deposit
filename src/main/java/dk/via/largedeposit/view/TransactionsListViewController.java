package dk.via.largedeposit.view;

import dk.via.largedeposit.model.Account;
import dk.via.largedeposit.model.Transaction;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.model.enums.Currency;
import dk.via.largedeposit.model.enums.UserRole;
import dk.via.largedeposit.viewmodel.TransactionsListViewModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

import java.util.ArrayList;

public class TransactionsListViewController {

    @FXML
    private TableView<Transaction> transactionList;


    private TransactionsListViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    /**
     * Initializer
     * @param viewHandler the View Handler
     * @param viewModel the View Model
     * @param root the root
     */
    public void init (ViewHandler viewHandler, TransactionsListViewModel viewModel, Region root) {
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

        var transactions = new ArrayList<Transaction>();
        for (int i = 0; i < 10; i++) {
            transactions.add(new Transaction(i, 100, System.currentTimeMillis(), user, accounts.get(0), accounts.get(1), true, user, "Approved"));
        }

        var observableCollection = FXCollections.observableList(transactions);
        transactionList.setItems(observableCollection);
    }

    /**
     * Handler
     */
    @FXML
    private void handleAccountsButtonAction() {
        viewHandler.openView(ViewFactory.ACCOUNTS_LIST);
    }

    /**
     * Handler
     */
    @FXML
    private void handleUsersListButtonAction() {
        viewHandler.openView(ViewFactory.USERS_LIST);
    }

    /**
     * Handler
     */
    @FXML
    private void handleActivateDeactivateButtonAction() {
        System.out.println("Activate/Deactivate button clicked");
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
