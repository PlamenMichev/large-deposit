package dk.via.largedeposit.view;

import dk.via.largedeposit.model.Account;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.model.enums.Currency;
import dk.via.largedeposit.model.enums.UserRole;
import dk.via.largedeposit.viewmodel.OverviewViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.util.ArrayList;

public class OverviewViewController {
    @FXML
    private TableView<Account> accountsTable;
    private OverviewViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, OverviewViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        var accounts = viewModel.getAccounts();
        accountsTable.setItems(accounts);

        accountsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Perform your action here
                this.viewHandler.openView(ViewFactory.ACCOUNT_DETAILS);
            }
        });
    }

    @FXML
    private void handleCreateNewAccountButtonAction() {
        viewHandler.openView(ViewFactory.CREATE_ACCOUNT);
    }

    @FXML
    private void handleCreateTransactionButtonAction() {
        viewHandler.openView(ViewFactory.CREATE_TRANSACTION);
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
    }
}
