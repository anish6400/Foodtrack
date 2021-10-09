package main.models;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import main.controllers.LoginPageController;

public class LoginPage extends VBox {
	private Node view;
	public LoginPageController loginPageController = new LoginPageController();
	
	
	public LoginPage(App app){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/views/LoginPageView.fxml"));
        fxmlLoader.setController(loginPageController);
        try {
            view = (Node) fxmlLoader.load();
            loginPageController.initialize(app);

        } catch (IOException ex) {
        	System.out.println(ex);
        }
        getChildren().add(view);
	}
}

