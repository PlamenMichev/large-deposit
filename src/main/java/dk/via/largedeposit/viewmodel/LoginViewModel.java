package dk.via.largedeposit.viewmodel;

import dk.via.largedeposit.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel {

    private StringProperty email;
    private StringProperty password;
    private final Model model;

    public LoginViewModel(Model model) {

        this.model = model;
        this.email = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
    }

    public void bindProperties(StringProperty email, StringProperty password) {
        email.bindBidirectional(this.email);
        password.bindBidirectional(this.password);
    }

    public void login() {
        this.model.login(email.getValue(), password.getValue());
    }
}
