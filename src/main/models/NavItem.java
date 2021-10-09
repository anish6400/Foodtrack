package main.models;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import main.controllers.NavItemController;

public class NavItem extends HBox {
	private Node view;
	public NavItemController navItemController = new NavItemController();
	
	
	public NavItem(String text, boolean isRed, App app){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/views/NavItemView.fxml"));
        fxmlLoader.setController(navItemController);
        try {
            view = (Node) fxmlLoader.load();
            navItemController.initialize(text, isRed, app);
        } catch (IOException ex) {
        	System.out.println(ex);
        }
        getChildren().add(view);
	}
}
