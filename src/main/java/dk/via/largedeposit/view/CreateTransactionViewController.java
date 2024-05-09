package dk.via.largedeposit.view;

import dk.via.largedeposit.viewmodel.CreateTransactionViewModel;
import javafx.scene.layout.Region;

public class CreateTransactionViewController {
    private CreateTransactionViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, CreateTransactionViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
    }
}
