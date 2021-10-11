package main.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import main.models.App;

public class BudgetPageController {
	
	@FXML private Text helpingLine;
	@FXML private Button editButton;
	@FXML private Text budgetVal;

	private App app;
	
	public void initialize(App app, String month, String budgetVal) {
		this.app = app;
		this.helpingLine.setText("Your " + month +" month's budget is");
		if(budgetVal.equals(null)) {
			this.budgetVal.setText("Budget not set. Please set your budget");
			this.editButton.setText("SET BUDGET");
		}
		else {
			this.budgetVal.setText("$ " + budgetVal);
		}
		this.updateGui();
	}

	//styles
	private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #FFFFFF; -fx-background-radius: 5px; -fx-border-color: #577CFF; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-padding: 10px 30px; -fx-text-fill: #577CFF;";
	private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #577CFF; -fx-background-radius: 5px; -fx-border-color: #577CFF; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-padding: 10px 30px; -fx-text-fill: #FFFFFF;";
	
	public void buttonEntered() {
		this.editButton.setStyle(HOVERED_BUTTON_STYLE);
	}
	
	public void buttonExited() {
		this.editButton.setStyle(IDLE_BUTTON_STYLE);
	}
	
	public void buttonClicked() {
		this.app.setActiveTab("editbudget");
	}
	
	public void updateGui() {
		this.editButton.setStyle(IDLE_BUTTON_STYLE);
	}	
	
}
