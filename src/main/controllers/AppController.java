package main.controllers;

import java.time.LocalDate;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import main.models.App;
import main.models.BudgetPage;
import main.models.EditBudgetPage;
import main.models.LoginPage;
import main.models.NavBar;
import main.models.SignupPage;
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
		else if(this.app.getActiveTab().equals("signup")) {
			this.mainContainer.getChildren().add(new SignupPage(app));
		}
		else if(this.app.getActiveTab().equals("budget")) {
			LocalDate timeInfo = LocalDate.now();
			Map<Object, Object> response = this.app.dbConn.getUserBudget(this.app.getUserId(), timeInfo.getMonth().toString().toLowerCase(), Integer.toString(timeInfo.getYear()).toLowerCase());
			if(response.get("budgetSet").toString().equals("true")){
				this.mainContainer.getChildren().add(new BudgetPage(this.app, timeInfo.getMonth().toString().toLowerCase(), response.get("budget").toString()));
			}
			else {
				this.app.setActiveTab("editbudget");
			}
		}
		else if(this.app.getActiveTab().equals("editbudget")) {
			LocalDate timeInfo = LocalDate.now();
			Map<Object, Object> response = this.app.dbConn.getUserBudget(this.app.getUserId(), timeInfo.getMonth().toString().toLowerCase(), Integer.toString(timeInfo.getYear()).toLowerCase());
			this.mainContainer.getChildren().add(new EditBudgetPage(this.app, timeInfo.getMonth().toString().toLowerCase()));
		}
	}
	
}