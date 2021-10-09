package main.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import main.models.App;
import main.models.LoginPage;
import main.models.NavBar;
import main.models.TitleBar;

public class AppController{
	
	@FXML private VBox navBar;
	@FXML private HBox titleBar;
	@FXML private Pane mainContainer;
	
	private App app;
	
	public void initialize(App app) {
		this.app = app;
		this.updateGui();
	}
	
	public void updateGui() {
		this.navBar.getChildren().clear();
		this.titleBar.getChildren().clear();
		this.mainContainer.getChildren().clear();
		this.navBar.getChildren().add(new NavBar(app));
		this.titleBar.getChildren().add(new TitleBar(app));
		if(this.app.getActiveTab().equals("login")) {
			this.mainContainer.getChildren().add(new LoginPage(app));
		}
	}
	
}