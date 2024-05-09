package dk.via.largedeposit.viewmodel;

import dk.via.largedeposit.model.Model;

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

    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }

    public RegisterViewModel getRegisterViewModel() {
        return registerViewModel;
    }

    public OverviewViewModel getOverviewViewModel() {
        return overviewViewModel;
    }

    public CreateTransactionViewModel getCreateTransactionViewModel() {
        return createTransactionViewModel;
    }

    public AccountDetailsViewModel getAccountDetailsViewModel() {
        return accountDetailsViewModel;
    }

    public CreateAccountViewModel getCreateAccountViewModel() {
        return createAccountViewModel;
    }

    public UsersListViewModel getUsersListViewModel() {
        return usersListViewModel;
    }

    public AccountsListViewModel getAccountsListViewModel() {
        return accountsListViewModel;
    }

    public TransactionsListViewModel getTransactionsListViewModel() {
        return transactionsListViewModel;
    }
}
