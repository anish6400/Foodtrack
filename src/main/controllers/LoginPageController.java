package main.controllers;

import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import main.models.App;

public class LoginPageController {
	
	@FXML private TextField usernameField;
	@FXML private TextField passwordField;
	@FXML private Text errorMessage;
	
	private App app;
	
	public void initialize(App app) {
		this.errorMessage.setVisible(false);
		this.app = app;
	}
	
	public void loginButtonClicked() {
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
	
	public void createNewAccountClicked() {
		this.app.setActiveTab("signup");
	}
	
}
