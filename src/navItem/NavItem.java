package navItem;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class NavItem extends HBox {
	private Node view;
	public NavItemController navItemController = new NavItemController();
	
	
	public NavItem(String text, String iconPath, boolean active, String uniqueColor){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NavItemView.fxml"));
        fxmlLoader.setController(navItemController);
        try {
            view = (Node) fxmlLoader.load();
            navItemController.initialize(text, iconPath, active, uniqueColor);

        } catch (IOException ex) {
        	System.out.println(ex);
        }
        getChildren().add(view);
	}
}
