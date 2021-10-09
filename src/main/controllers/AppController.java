package main.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import main.models.App;
import main.models.NavBar;

public class AppController{
	
	@FXML private VBox navBar;
	
	private App app;
	
	public void initialize(App app) {
		this.app = app;
		this.updateGui();
	}
	
	public void updateGui() {
		this.navBar.getChildren().clear();
		this.navBar.getChildren().add(new NavBar(app));
	}
	
}