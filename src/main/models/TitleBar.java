package main.models;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import main.controllers.TitleBarController;

public class TitleBar extends HBox {
	private Node view;
	public TitleBarController titleBarController = new TitleBarController();
	
	
	public TitleBar(App app){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/views/TitleBarView.fxml"));
        fxmlLoader.setController(titleBarController);
        try {
            view = (Node) fxmlLoader.load();
            titleBarController.initialize(app);

        } catch (IOException ex) {
        	System.out.println(ex);
        }
        getChildren().add(view);
	}
}