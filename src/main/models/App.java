package main.models;
 
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.controllers.AppController;
 
public class App extends Application {
	
	private String activeTab = "editbudget";
	private String userId, fullName;
	private AppController appController = new AppController();
	/*
	 * List of active tabs:
	 * 1.login-
	 * 2.signup-
	 * 3.budget-
	 * 4.editBudget
	 * 5.food-
	 * 6.shoppingHistory-
	 * 7.addShoppingDetails
	 * 8.editShoppingDetails
	 * 9.addFoodConsumption
	 * 10.reports-
	 */
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new BorderPane());
	    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/views/AppView.fxml"));
	    fxmlLoader.setController(appController);
  	    scene.setRoot((Parent) fxmlLoader.load());
	    appController.initialize(this);
    	stage.setTitle("FoodTrack");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
	public String getActiveTab() {
		return activeTab;
	}

	public void setActiveTab(String activeTab) {
		this.activeTab = activeTab;
		this.appController.initialize(this);
	}
}