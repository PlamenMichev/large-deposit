package dk.via.largedeposit.viewmodel;

import dk.via.largedeposit.model.Model;

/**
 * View Model for creating transactions
 */
public class CreateTransactionViewModel {
    private final Model model;

    /**
     * Constructor
     * @param model the model
     */
    public CreateTransactionViewModel(Model model) {
        this.model = model;
    }
}
