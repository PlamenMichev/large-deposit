package dk.via.largedeposit.viewmodel;

import dk.via.largedeposit.model.Model;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.shared.ObserverEvents;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class UsersListViewModel implements PropertyChangeListener {
    private final Model model;
    private ObservableList<User> users;

    public UsersListViewModel(Model model) {
        this.model = model;
        this.model.addPropertyChangeListener(this);
        this.users = FXCollections.observableArrayList();
    }

    public ObservableList<User> getUnverifiedUsers() {
        try {
            var allUsers = model.getUsers();
            var unverifiedUsers = allUsers.stream().filter(user -> !user.getIsVerified()).toList();
            this.users = FXCollections.observableArrayList(unverifiedUsers);
            return this.users;
        } catch (Exception e) {
            return FXCollections.observableArrayList();
        }
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(ObserverEvents.USER_CREATED)) {
            Platform.runLater(() -> this.addUser((User) evt.getNewValue()));
        }
    }
}
