package dk.via.largedeposit.view;

import dk.via.largedeposit.model.Account;
import dk.via.largedeposit.model.Transaction;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.model.enums.Currency;
import dk.via.largedeposit.model.enums.UserRole;
import dk.via.largedeposit.viewmodel.AccountDetailsViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

import java.util.ArrayList;

public class AccountDetailsViewController {

    @FXML
    private Label accountNumberLabel;

    @FXML
    private Label titleLabel;

    @FXML
    private TableView<Transaction> transactionsTable;


    private AccountDetailsViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, AccountDetailsViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        var accounts = new ArrayList<Account>();
        var user = new User(1,"1234123412", "John", "Doe", UserRole.CUSTOMER, "Test address",
                "1234", "City", "93833920", "plamen@mail.dl", "parola123",
                true, 10000, 100000);

        var transactions = new ArrayList<Transaction>();
        for (int i = 0; i < 10; i++) {
            transactions.add(new Transaction(i, 100, System.currentTimeMillis(), user, accounts.get(0), accounts.get(1), true, user, "Approved"));
        }

        var observableCollection = FXCollections.observableList(transactions);
        transactionsTable.setItems(observableCollection);
    }

    @FXML
    private void handleDeactivateAccountButtonAction() {
        System.out.println("Deactivate account button clicked");
    }

    @FXML
    private void handleBackButtonAction() {
        viewHandler.openView(ViewFactory.OVERVIEW);
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
    }
}
