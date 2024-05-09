package dk.via.largedeposit.view;
;
import dk.via.largedeposit.viewmodel.AccountsListViewModel;
import javafx.scene.layout.Region;

public class AccountsListViewController {

    private AccountsListViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, AccountsListViewModel viewModel, Region root) {
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
