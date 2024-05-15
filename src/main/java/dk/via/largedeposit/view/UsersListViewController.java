package dk.via.largedeposit.view;

import dk.via.largedeposit.model.User;
import dk.via.largedeposit.model.enums.UserRole;
import dk.via.largedeposit.viewmodel.UsersListViewModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

public class UsersListViewController {
    @FXML
    private TableView<User> userTable;

    private UsersListViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, UsersListViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        var user = new User("1234123412", "John", "Doe", UserRole.CUSTOMER, "Test address",
                "1234", "City", "93833920", "plamen@mail.dl", "parola123",
                true, 10000, 100000);
        var user1 = new User("1234123412", "John", "Doe", UserRole.CUSTOMER, "Test address",
                "1234", "City", "93833920", "plamen@mail.dl", "parola123",
                true, 10000, 100000);
        var user2 = new User("1234123412", "John", "Doe", UserRole.CUSTOMER, "Test address",
                "1234", "City", "93833920", "plamen@mail.dl", "parola123",
                true, 10000, 100000);

        var collection = FXCollections.observableArrayList(user, user1, user2);
        userTable.setItems(collection);
    }

    @FXML
    public void handleActivateDeactivateButtonAction() {
        // Retrieve selected user from the table
        User selectedUser = userTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            System.out.println("Selected user: " + selectedUser.getFirstName() + " " + selectedUser.getLastName());
            // Update the table view
            userTable.refresh();
        }
    }

    @FXML
    public void handleTransactionsButtonAction() {
        viewHandler.openView(ViewFactory.TRANSACTIONS_LIST);
    }

    @FXML
    public void handleAccountsListButtonAction() {
        viewHandler.openView(ViewFactory.ACCOUNTS_LIST);
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
    }
}
