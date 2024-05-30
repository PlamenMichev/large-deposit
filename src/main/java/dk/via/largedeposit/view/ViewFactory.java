package dk.via.largedeposit.view;

import dk.via.largedeposit.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOError;
import java.io.IOException;

/**
 * View Factory for the app
 */
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

    // Controllers
    private LoginViewController loginViewController;
    private RegisterViewController registerViewController;
    private OverviewViewController overviewViewController;
    private CreateTransactionViewController createTransactionViewController;
    private AccountDetailsViewController accountDetailsViewController;
    private CreateAccountViewController createAccountViewController;
    private UsersListViewController usersListViewController;
    private AccountsListViewController accountsListViewController;
    private TransactionsListViewController transactionsListViewController;


    private final ViewHandler viewHandler;
    private final ViewModelFactory viewModelFactory;

    /**
     * Constructor
     * @param viewHandler the View Handler
     * @param viewModelFactory the View Model Factory
     */
    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.loginViewController = null;
        this.registerViewController = null;
        this.overviewViewController = null;
        this.createTransactionViewController = null;
        this.accountDetailsViewController = null;
        this.createAccountViewController = null;
        this.usersListViewController = null;
        this.accountsListViewController = null;
        this.transactionsListViewController = null;
    }

    /**
     * Method used to load the login view
     * @return the root of the view
     */
    public Region loadLoginView() {
        if (loginViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("LoginView.fxml"));
            try {
                Region root = loader.load();
                loginViewController = loader.getController();
                loginViewController.init(viewHandler, viewModelFactory.getLoginViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }

        loginViewController.reset();
        return loginViewController.getRoot();
    }

    /**
     * Method used to load the register view
     * @return the root of the view
     */
    public Region loadRegisterView() {
        if (registerViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("RegisterView.fxml"));
            try {
                Region root = loader.load();
                registerViewController = loader.getController();
                registerViewController.init(viewHandler, viewModelFactory.getRegisterViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }

        registerViewController.reset();
        return registerViewController.getRoot();
    }

    /**
     * Method used to load the overview view
     * @return the root of the view
     */
    public Region loadOverviewView() {
        if (overviewViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("OverviewView.fxml"));
            try {
                Region root = loader.load();
                overviewViewController = loader.getController();
                overviewViewController.init(viewHandler, viewModelFactory.getOverviewViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }

        overviewViewController.reset();
        return overviewViewController.getRoot();
    }

    /**
     * Method used to load the create transaction view
     * @return the root of the view
     */
    public Region loadCreateTransactionView() {
        if (createTransactionViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CreateTransactionView.fxml"));
            try {
                Region root = loader.load();
                createTransactionViewController = loader.getController();
                createTransactionViewController.init(viewHandler, viewModelFactory.getCreateTransactionViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }

        createTransactionViewController.reset();
        return createTransactionViewController.getRoot();
    }

    /**
     * Method used to load the account details view
     * @return the root of the view
     */
    public Region loadAccountDetailsView() {
        if (accountDetailsViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AccountDetailsView.fxml"));
            try {
                Region root = loader.load();
                accountDetailsViewController = loader.getController();
                accountDetailsViewController.init(viewHandler, viewModelFactory.getAccountDetailsViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }

        accountDetailsViewController.reset();
        return accountDetailsViewController.getRoot();
    }

    /**
     * Method used to load the create account view
     * @return the root of the view
     */
    public Region loadCreateAccountView() {
        if (createAccountViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CreateAccountView.fxml"));
            try {
                Region root = loader.load();
                createAccountViewController = loader.getController();
                createAccountViewController.init(viewHandler, viewModelFactory.getCreateAccountViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }

        createAccountViewController.reset();
        return createAccountViewController.getRoot();
    }

    /**
     * Method used to load the user list view
     * @return the root of the view
     */
    public Region loadUsersListView() {
        if (usersListViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("UsersListView.fxml"));
            try {
                Region root = loader.load();
                usersListViewController = loader.getController();
                usersListViewController.init(viewHandler, viewModelFactory.getUsersListViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }

        usersListViewController.reset();
        return usersListViewController.getRoot();
    }

    /**
     * Method used to load the account list view
     * @return the root of the view
     */
    public Region loadAccountsListView() {
        if (accountsListViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AccountsListView.fxml"));
            try {
                Region root = loader.load();
                accountsListViewController = loader.getController();
                accountsListViewController.init(viewHandler, viewModelFactory.getAccountsListViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }

        accountsListViewController.reset();
        return accountsListViewController.getRoot();
    }

    /**
     * Method used to load the transactions list view
     * @return the root of the view
     */
    public Region loadTransactionsListView() {
        if (transactionsListViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TransactionsListView.fxml"));
            try {
                Region root = loader.load();
                transactionsListViewController = loader.getController();
                transactionsListViewController.init(viewHandler, viewModelFactory.getTransactionsListViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }

        transactionsListViewController.reset();
        return transactionsListViewController.getRoot();
    }

    /**
     * loader for views
     * @param id the id of the view
     * @return
     */
    public Region load(String id) {
        return switch(id) {
            case LOGIN -> loadLoginView();
            case REGISTER -> loadRegisterView();
            case OVERVIEW -> loadOverviewView();
            case CREATE_TRANSACTION -> loadCreateTransactionView();
            case ACCOUNT_DETAILS -> loadAccountDetailsView();
            case CREATE_ACCOUNT -> loadCreateAccountView();
            case USERS_LIST -> loadUsersListView();
            case ACCOUNTS_LIST -> loadAccountsListView();
            case TRANSACTIONS_LIST -> loadTransactionsListView();
            default -> throw new IllegalArgumentException("Unknown view: " + id);
        };
    }
}
