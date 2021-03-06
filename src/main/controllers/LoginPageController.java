package main.controllers;

import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import main.models.App;

public class LoginPageController {
	
	@FXML private TextField usernameField;
	@FXML private PasswordField passwordField;
	@FXML private Text errorMessage;
	@FXML private Button loginButton;
	
	private App app;
	
	public void initialize(App app) {
		this.errorMessage.setVisible(false);
		this.app = app;
		this.updateGui();
	}
	
	public void buttonClicked() {
		Map<Object, Object> response = this.app.dbConn.login(this.usernameField.getText(), this.passwordField.getText());
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
		this.loginButton.setStyle(HOVERED_BUTTON_STYLE);
	}
	
	public void buttonExited() {
		this.loginButton.setStyle(IDLE_BUTTON_STYLE);
	}
	
	public void createNewAccountClicked() {
		this.app.setActiveTab("signup");
	}
	
	public void updateGui() {
		this.loginButton.setStyle(IDLE_BUTTON_STYLE);
	}
	
}
