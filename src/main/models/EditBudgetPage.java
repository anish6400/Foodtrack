package main.models;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import main.controllers.EditBudgetPageController;

public class EditBudgetPage extends VBox {
	private Node view;
	public EditBudgetPageController editBudgetPageController = new EditBudgetPageController();
	
	
	public EditBudgetPage(App app, String month){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/views/EditBudgetPageView.fxml"));
        fxmlLoader.setController(editBudgetPageController);
        try {
            view = (Node) fxmlLoader.load();
            editBudgetPageController.initialize(app, month);

        } catch (IOException ex) {
        	System.out.println(ex);
        }
        getChildren().add(view);
	}
}