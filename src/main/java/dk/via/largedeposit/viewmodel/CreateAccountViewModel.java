package dk.via.largedeposit.viewmodel;

import dk.via.largedeposit.model.Model;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * View Model for creating accounts
 */
public class CreateAccountViewModel {
    private final Model model;

    private StringProperty type;
    private StringProperty title;
    private StringProperty currency;

    /**
     * Constructor
     * @param model the model
     */
    public CreateAccountViewModel(Model model) {
        this.model = model;
        this.type = new SimpleStringProperty();
        this.title = new SimpleStringProperty();
        this.currency = new SimpleStringProperty();
    }

    public void bindProperties(ObjectProperty<String> type, StringProperty title, ObjectProperty<String> currency) {
        this.type.bindBidirectional(type);
        this.title.bindBidirectional(title);
        this.currency.bindBidirectional(currency);
    }

    public void createAccount() {
        model.createAccount(type.get(), title.get(), currency.get(), null);
    }
}
