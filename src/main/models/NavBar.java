package main.models;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import main.controllers.NavBarController;

public class NavBar extends VBox {
	private Node view;
	public NavBarController navBarController = new NavBarController();
	
	
	public NavBar(App app){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/views/NavBarView.fxml"));
        fxmlLoader.setController(navBarController);
        try {
            view = (Node) fxmlLoader.load();
            navBarController.initialize(app);

        } catch (IOException ex) {
        	System.out.println(ex);
        }
        getChildren().add(view);
	}
}
