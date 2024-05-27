package dk.via.largedeposit.viewmodel;

import dk.via.largedeposit.model.Model;

/**
 * View Model for creating accounts
 */
public class CreateAccountViewModel {
    private final Model model;

    /**
     * Constructor
     * @param model the model
     */
    public CreateAccountViewModel(Model model) {
        this.model = model;
    }
}
