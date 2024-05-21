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

        var users = viewModel.getUnverifiedUsers();
        userTable.setItems(users);
    }

    @FXML
    public void handleActivateDeactivateButtonAction() {
        // Retrieve selected user from the table
        User selectedUser = userTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            System.out.println("Selected user: " + selectedUser.getFirstName() + " " + selectedUser.getLastName());
            // Update the table view
//            userTable.refresh();
            this.viewModel.addUser(selectedUser);
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
