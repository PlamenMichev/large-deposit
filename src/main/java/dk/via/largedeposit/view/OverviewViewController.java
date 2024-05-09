package dk.via.largedeposit.view;

import dk.via.largedeposit.viewmodel.OverviewViewModel;
import javafx.scene.layout.Region;

public class OverviewViewController {
    private OverviewViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;

    public void init (ViewHandler viewHandler, OverviewViewModel viewModel, Region root) {
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
