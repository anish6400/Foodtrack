package main.models;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import main.controllers.BudgetPageController;

public class BudgetPage extends VBox {
	private Node view;
	public BudgetPageController budgetPageController = new BudgetPageController();
	
	
	public BudgetPage(App app, String month, String budgetVal){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/views/BudgetPageView.fxml"));
        fxmlLoader.setController(budgetPageController);
        try {
            view = (Node) fxmlLoader.load();
            budgetPageController.initialize(app, month, budgetVal);

        } catch (IOException ex) {
        	System.out.println(ex);
        }
        getChildren().add(view);
	}
}