package dk.via.largedeposit.view;

import dk.via.largedeposit.model.Account;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.model.enums.Currency;
import dk.via.largedeposit.model.enums.UserRole;
import dk.via.largedeposit.viewmodel.OverviewViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.util.ArrayList;

public class OverviewViewController {

    @FXML
    private GridPane accountList;

    private OverviewViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, OverviewViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        var accounts = viewModel.getAccounts();

        // Populate the account list grid
        int row = 0;
        int col = 0;
        // Populate the account list
        for (Account account : accounts) {
            Label accountInfoLabel = new Label(
                    "Account Number: " + account.getAccountNumber() + "\n" +
                            "Registration Number: " + account.getRegNumber()+ "\n" +
                            "Title: " + account.getTitle() + "\n" +
                            "Currency: " + account.getCurrency() + "\n" +
                            "Balance: " + account.getBalance() + "\n" +
                            "Active: " + (account.isActive() ? "Yes" : "No") + "\n" +
                            "Iban: " + account.getIban() + "\n"
            );

            // Add border around the label
            accountInfoLabel.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
            accountInfoLabel.setOnMouseClicked((event) -> viewHandler.openView(ViewFactory.ACCOUNT_DETAILS));
            accountList.add(accountInfoLabel, col, row);
            col++;
            if (col == 3) {
                col = 0;
                row++;
            }
        }
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
