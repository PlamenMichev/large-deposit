package dk.via.largedeposit.view;

import dk.via.largedeposit.viewmodel.TransactionsListViewModel;
import javafx.scene.layout.Region;

public class TransactionsListViewController {
    private TransactionsListViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, TransactionsListViewModel viewModel, Region root) {
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
