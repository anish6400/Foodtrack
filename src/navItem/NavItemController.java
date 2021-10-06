package navItem;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class NavItemController {
	@FXML private HBox navItemContainer;
	@FXML private Text navItemText;
	@FXML private ImageView navItemIcon;
	
	private static final String ACTIVE_ITEM_STYLE = "-fx-background-color: #577CFF;";
	private static final String IDLE_ITEM_STYLE = "-fx-background-color: #FFFFFF; -fx-border-color: #E5EBEB; -fx-border-width: 0 0 1px 0";
	private static final String ACTIVE_TEXT_STYLE = "-fx-fill: #FFFFFF; -fx-font-size: 18px;";
	private static final String IDLE_TEXT_STYLE = "-fx-fill: #333333; -fx-font-size: 18px;";

	
	public void initialize(String text, String iconPath, boolean active, String uniqueColor) {
		this.navItemText.setText(text);
		this.navItemContainer.setStyle(IDLE_ITEM_STYLE);
	}
	
	public void navItemClicked() {
		
	}
	
	public void navItemEntered() {
		this.navItemText.setStyle(ACTIVE_TEXT_STYLE);
		this.navItemContainer.setStyle(ACTIVE_ITEM_STYLE);
	}
	
	public void navItemExited() {
		this.navItemText.setStyle(IDLE_TEXT_STYLE);
		this.navItemContainer.setStyle(IDLE_ITEM_STYLE);
	}
}
