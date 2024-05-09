package dk.via.largedeposit.view;

import dk.via.largedeposit.viewmodel.UsersListViewModel;
import javafx.scene.layout.Region;

public class UsersListViewController {
    private UsersListViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, UsersListViewModel viewModel, Region root) {
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
