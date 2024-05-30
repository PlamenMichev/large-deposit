package dk.via.largedeposit.viewmodel;

import dk.via.largedeposit.model.Model;

/**
 * View Model for the transactions
 */
public class TransactionsListViewModel {
    private final Model model;

    /**
     * Constructor
     * @param model the model
     */
    public TransactionsListViewModel(Model model) {
        this.model = model;
    }
}
