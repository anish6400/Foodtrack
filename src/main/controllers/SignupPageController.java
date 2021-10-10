package main.controllers;

import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import main.models.App;

public class SignupPageController {
	
	@FXML private TextField fullNameField;
	@FXML private TextField usernameField;
	@FXML private PasswordField passwordField;
	@FXML private Text errorMessage;
	@FXML private Button signupButton;
	
	private App app;
	
	public void initialize(App app) {
		this.errorMessage.setVisible(false);
		this.app = app;
		this.updateGui();
	}
	
	public void buttonClicked() {
		Map<Object, Object> response = this.app.dbConn.signup(this.fullNameField.getText(), this.usernameField.getText(), this.passwordField.getText());
		if(response.get("success").toString().equals("true") ) {
			this.app.setUserId(response.get("userId").toString());
			this.app.setUserName(response.get("userName").toString());
			this.app.setUserFullName(response.get("fullName").toString());
			this.app.setActiveTab("budget");
		}
		else {
			this.errorMessage.setText(response.get("error").toString());
			this.errorMessage.setVisible(true);
		}
	}
	
	//styles
	private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #FFFFFF; -fx-background-radius: 5px; -fx-border-color: #577CFF; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-padding: 10px 30px; -fx-text-fill: #577CFF;";
	private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #577CFF; -fx-background-radius: 5px; -fx-border-color: #577CFF; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-padding: 10px 30px; -fx-text-fill: #FFFFFF;";
	
	public void buttonEntered() {
		this.signupButton.setStyle(HOVERED_BUTTON_STYLE);
	}
	
	public void buttonExited() {
		this.signupButton.setStyle(IDLE_BUTTON_STYLE);
	}
	
	public void loginClicked() {
		this.app.setActiveTab("login");
	}
	
	public void updateGui() {
		this.signupButton.setStyle(IDLE_BUTTON_STYLE);
	}
	
}
