package dk.via.largedeposit.viewmodel;

import dk.via.largedeposit.model.Account;
import dk.via.largedeposit.model.Model;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.shared.ObserverEvents;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * View Model for overview
 */
public class OverviewViewModel implements PropertyChangeListener {

    private final Model model;
    private ObservableList<Account> accounts;


    /**
     * Constructor
     * @param model the model
     */
    public OverviewViewModel(Model model) {
        this.model = model;
        this.model.addPropertyChangeListener(this);
        this.accounts = FXCollections.observableArrayList();
    }

    public ObservableList<Account> getAccounts() {
        try {
            var result = model.getAccounts();
            this.accounts = FXCollections.observableArrayList(result);
            return this.accounts;
        } catch (Exception e) {
            return FXCollections.observableArrayList();
        }
    }

    public void addAccount(Account user) {
        this.accounts.add(user);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(ObserverEvents.ACCOUNT_CREATED)) {
            Platform.runLater(() -> this.addAccount((Account) evt.getNewValue()));
        }
    }
}
