package dk.via.largedeposit.viewmodel;

import dk.via.largedeposit.model.Model;
import dk.via.largedeposit.model.enums.UserRole;
import dk.via.largedeposit.view.ViewFactory;
import dk.via.largedeposit.view.ViewHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * View Model for login
 */
public class LoginViewModel {

    private StringProperty email;
    private StringProperty password;
    private final Model model;

    /**
     * Constructor
     * @param model the model
     */
    public LoginViewModel(Model model) {

        this.model = model;
        this.email = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
    }

    public void bindProperties(StringProperty email, StringProperty password) {
        email.bindBidirectional(this.email);
        password.bindBidirectional(this.password);
    }

    /**
     * Method used to login a user
     * @return the overview from ViewFactory
     */
    public String login() {
        this.model.login(email.getValue(), password.getValue());
        var currentUser = this.model.getCurrentUser();
        if (currentUser.getRole() == UserRole.CUSTOMER) {
            return ViewFactory.OVERVIEW;
        }

        return ViewFactory.USERS_LIST;
    }
}
