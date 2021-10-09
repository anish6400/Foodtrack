package main.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import main.models.App;
import main.models.NavItem;

public class NavBarController{
	
	@FXML private VBox navBar;
	
	private App app;
	private String[] NavItemsLoggedOut = {"Login", "SignUp"};
	private String[] NavItemsLoggedIn = {"Budget", "Food Inventory", "Shopping History", "Add Shopping Details", "Add Food Consumption", "Reports"};
	
	public void initialize(App app) {
		this.app = app;
		this.updateGui();
	}
	
	private void updateGui() {
		this.navBar.getChildren().clear();
		String currentActiveTab = this.app.getActiveTab().toLowerCase().trim();
		if(currentActiveTab.equals("login") || currentActiveTab.equals("signup")) {
			for(String text: this.NavItemsLoggedOut) {
				this.navBar.getChildren().add(new NavItem(text, false, this.app));
			}
			this.navBar.getChildren().add(new NavItem("Exit", true, this.app));
		}
		else {
			for(String text: this.NavItemsLoggedIn) {
				NavItem temp = new NavItem(text, false, this.app);
				this.navBar.getChildren().add(temp);
			}
			this.navBar.getChildren().add(new NavItem("Logout", true, this.app));
			this.navBar.getChildren().add(new NavItem("Exit", true, this.app));
		}
	}
	
}