package main.models;
 
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.controllers.AppController;
import main.services.DbConnection;
 
public class App extends Application {
	
	public static  DbConnection dbConn;
	private String activeTab = "login";
	private String userId, userName, userFullName;
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
	
    public static void main(String[] args) throws Exception {
    	if(args.length == 6) {
    		dbConn = new DbConnection(args[1], args[3], args[5]);
    	}
    	else {
    		throw new IllegalArgumentException("Arguments missing...");
    	}
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
	
	public void logout() {
		this.setUserId(null);
		this.setUserFullName(null);
		this.setActiveTab("login");
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
}