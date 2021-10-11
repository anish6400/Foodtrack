package main.controllers;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import main.models.App;

public class EditBudgetPageController {
	
	@FXML private Text helpingLine;
	@FXML private Button saveButton;
	@FXML private Button cancelButton;
	@FXML private TextField budgetField;

	private App app;

	public void initialize(App app, String month) {
		this.app = app;
		this.helpingLine.setText("Set your " + month + " month's budget.");
		this.updateGui();
	}
	
	//styles
	private static final String HOVERED_CANCEL_BUTTON_STYLE = "-fx-background-color: #E5EBEB; -fx-background-radius: 5px; -fx-border-color: #E5EBEB; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-padding: 10px 30px; -fx-text-fill: #577CFF;";
	private static final String IDLE_CANCEL_BUTTON_STYLE = "-fx-background-color: #FFFFFF; -fx-background-radius: 5px; -fx-border-color: #FFFFFF; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-padding: 10px 30px; -fx-text-fill: #577CFF;";
	private static final String HOVERED_SAVE_BUTTON_STYLE = "-fx-background-color: #FFFFFF; -fx-background-radius: 5px; -fx-border-color: #577CFF; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-padding: 10px 30px; -fx-text-fill: #577CFF;";
	private static final String IDLE_SAVE_BUTTON_STYLE = "-fx-background-color: #577CFF; -fx-background-radius: 5px; -fx-border-color: #577CFF; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-padding: 10px 30px; -fx-text-fill: #FFFFFF;";
	
	
	public void cancelButtonEntered() {
		this.cancelButton.setStyle(HOVERED_CANCEL_BUTTON_STYLE);
	}
	
	public void cancelButtonExited() {
		this.cancelButton.setStyle(IDLE_CANCEL_BUTTON_STYLE);
	}
	
	public void cancelButtonClicked() {
		this.app.setActiveTab("budget");
	}
	
	public void saveButtonEntered() {
		this.saveButton.setStyle(HOVERED_SAVE_BUTTON_STYLE);
	}
	
	public void saveButtonExited() {
		this.saveButton.setStyle(IDLE_SAVE_BUTTON_STYLE);
	}
	
	public void saveButtonClicked() {
		if(!this.budgetField.getText().equals("")) {
			this.app.dbConn.setUserBudget(this.app.getUserId(), LocalDate.now().getMonth().toString(), String.valueOf(LocalDate.now().getYear()), this.budgetField.getText());
		}
		this.app.setActiveTab("budget");
	}
	
	public void updateGui() {
		this.budgetField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("\\d.")) {
	            this.budgetField.setText(newValue.replaceAll("[^\\d.]", ""));
	        }
		});
		this.cancelButton.setStyle(IDLE_CANCEL_BUTTON_STYLE);
		this.saveButton.setStyle(IDLE_SAVE_BUTTON_STYLE);
	}	

}
