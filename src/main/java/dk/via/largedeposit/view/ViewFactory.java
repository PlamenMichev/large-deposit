package dk.via.largedeposit.view;

import dk.via.largedeposit.viewmodel.ViewModelFactory;
import javafx.scene.layout.Region;

public class ViewFactory {
    public static final String LOGIN = "Login";
    public static final String REGISTER = "Register";
    public static final String OVERVIEW = "Overview";
    public static final String CREATE_TRANSACTION = "CreateTransaction";
    public static final String ACCOUNT_DETAILS = "AccountDetails";
    public static final String CREATE_ACCOUNT = "CreateAccount";
    public static final String USERS_LIST = "UsersList";
    public static final String ACCOUNTS_LIST = "AccountsList";
    public static final String TRANSACTIONS_LIST = "TransactionsList";


    private final ViewHandler viewHandler;
    private final ViewModelFactory viewModelFactory;

    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
    }

    public Region load(String id) {
        return switch(id) {
            case LOGIN -> new Region();
            default -> throw new IllegalArgumentException("Unknown view: " + id);
        };
    }
}
