package dk.via.largedeposit.view;

import dk.via.largedeposit.viewmodel.AccountDetailsViewModel;
import javafx.scene.layout.Region;

public class AccountDetailsViewController {

    private AccountDetailsViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, AccountDetailsViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
    }
}
