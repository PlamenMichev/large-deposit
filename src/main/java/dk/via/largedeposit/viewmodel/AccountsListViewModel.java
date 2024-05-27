package dk.via.largedeposit.viewmodel;

import dk.via.largedeposit.model.Model;

/**
 * View Model for the account list
 */
public class AccountsListViewModel {
    private final Model model;

    /**
     * Constructor
     * @param model the model
     */
    public AccountsListViewModel(Model model) {
        this.model = model;
    }
}
