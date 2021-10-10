package main.models;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import main.controllers.SignupPageController;

public class SignupPage extends VBox {
	private Node view;
	public SignupPageController signupPageController = new SignupPageController();
	
	
	public SignupPage(App app){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/views/SignupPageView.fxml"));
        fxmlLoader.setController(signupPageController);
        try {
            view = (Node) fxmlLoader.load();
            signupPageController.initialize(app);

        } catch (IOException ex) {
        	System.out.println(ex);
        }
        getChildren().add(view);
	}
}

