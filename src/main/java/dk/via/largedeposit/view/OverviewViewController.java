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

        // Populate the account list grid
        int row = 0;
        int col = 0;
        // Populate the account list
        for (Account account : accounts) {
            Label accountInfoLabel = new Label(
                    "Account Number: " + account.getNumber() + "\n" +
                            "Registration Number: " + account.getNumber()+ "\n" +
                            "Title: " + account.getTitle() + "\n" +
                            "Currency: " + account.getCurrency() + "\n" +
                            "Balance: " + account.getBalance() + "\n" +
                            "Active: " + (account.isActive() ? "Yes" : "No") + "\n" +
                            "Iban: " + account.getIban() + "\n"
            );

            // Add border around the label
            accountInfoLabel.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
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

    public Region getRoot() {
        return root;
    }

    public void reset() {
    }
}
