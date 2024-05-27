package dk.via.largedeposit.viewmodel;

import dk.via.largedeposit.model.Model;

/**
 * Class used to manage all view models
 */
public class ViewModelFactory {
    private final LoginViewModel loginViewModel;
    private final RegisterViewModel registerViewModel;
    private final OverviewViewModel overviewViewModel;
    private final CreateTransactionViewModel createTransactionViewModel;
    private final AccountDetailsViewModel accountDetailsViewModel;
    private final CreateAccountViewModel createAccountViewModel;
    private final UsersListViewModel usersListViewModel;
    private final AccountsListViewModel accountsListViewModel;
    private final TransactionsListViewModel transactionsListViewModel;

    /**
     * Constructor
     * @param model the model
     */
    public ViewModelFactory(Model model) {
        this.loginViewModel = new LoginViewModel(model);
        this.registerViewModel = new RegisterViewModel(model);
        this.overviewViewModel = new OverviewViewModel(model);
        this.createTransactionViewModel = new CreateTransactionViewModel(model);
        this.accountDetailsViewModel = new AccountDetailsViewModel(model);
        this.createAccountViewModel = new CreateAccountViewModel(model);
        this.usersListViewModel = new UsersListViewModel(model);
        this.accountsListViewModel = new AccountsListViewModel(model);
        this.transactionsListViewModel = new TransactionsListViewModel(model);
    }

    /**
     * Getter
     * @return loginViewModel
     */
    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }

    /**
     * Getter
     * @return registerViewModel
     */
    public RegisterViewModel getRegisterViewModel() {
        return registerViewModel;
    }

    /**
     * Getter
     * @return overviewViewModel
     */
    public OverviewViewModel getOverviewViewModel() {
        return overviewViewModel;
    }

    /**
     * Getter
     * @return createTransactionViewModel
     */
    public CreateTransactionViewModel getCreateTransactionViewModel() {
        return createTransactionViewModel;
    }

    /**
     * Getter
     * @return accountDetailsViewModel
     */
    public AccountDetailsViewModel getAccountDetailsViewModel() {
        return accountDetailsViewModel;
    }

    /**
     * Getter
     * @return createAccountViewModel
     */
    public CreateAccountViewModel getCreateAccountViewModel() {
        return createAccountViewModel;
    }

    /**
     * Getter
     * @return usersListViewModel
     */
    public UsersListViewModel getUsersListViewModel() {
        return usersListViewModel;
    }

    /**
     * Getter
     * @return accountsListViewModel
     */
    public AccountsListViewModel getAccountsListViewModel() {
        return accountsListViewModel;
    }

    /**
     * Getter
     * @return transactionsListViewModel
     */
    public TransactionsListViewModel getTransactionsListViewModel() {
        return transactionsListViewModel;
    }
}
