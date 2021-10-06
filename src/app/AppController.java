package app;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import navItem.NavItem;

public class AppController{
	
	@FXML private VBox navBar;
	
	public void initialize() {
		NavItem navitem1 = new NavItem("hello", null, false, null);
		this.navBar.getChildren().add(navitem1);
		NavItem navitem2 = new NavItem("hello2", null, false, null);
		this.navBar.getChildren().add(navitem2);
	}
	
}