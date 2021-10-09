package main.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import main.models.App;

public class NavItemController {
	@FXML private HBox navItemContainer;
	@FXML private Text navItemText;
	@FXML private ImageView navItemIcon;
	
	private String text;
	private boolean isRed;
	private boolean isActive = false;
	private App app;
	
	public void initialize(String text, boolean isRed, App app) {
		this.text = text;
		this.isRed = isRed;
		this.app = app;
		
		// checking for active tab
		String activeTab = this.app.getActiveTab().toLowerCase().replaceAll(" ","");;
		String tempText = this.text.toLowerCase().replaceAll(" ","");;
		if(activeTab.equals(tempText)) {
			this.isActive = true;
		}
		else if(activeTab.equals("editbudget") && tempText.equals("budget")) {
			this.isActive = true;
		}
		else if(activeTab.equals("editshoppingdetails") && tempText.equals("shoppinghistory")) {
			this.isActive = true;
		}
		else {
			this.isActive = false;
		}
		
		this.updateGui();
	}
	
	public void navItemClicked() {
		String tempText = this.text.toLowerCase().replaceAll(" ","");;
		if(tempText.equals("logout")) {
			this.app.logout();
		}
		else if(tempText.equals("exit")) {
			Platform.exit();
		}
		else {
			this.app.setActiveTab(tempText);
		}
	}
	
	// styles
	private static final String ACTIVE_ITEM_STYLE = "-fx-background-color: #577CFF;";
	private static final String IDLE_ITEM_STYLE = "-fx-background-color: #FFFFFF; -fx-border-color: #E5EBEB; -fx-border-width: 0 0 1px 0";
	private static final String ACTIVE_RED_ITEM_STYLE = "-fx-background-color: #ED4949;";
	private static final String ACTIVE_TEXT_STYLE = "-fx-fill: #FFFFFF; -fx-font-size: 18px;";
	private static final String IDLE_TEXT_STYLE = "-fx-fill: #333333; -fx-font-size: 18px;";
	private static final String IDLE_RED_TEXT_STYLE = "-fx-fill: #ED4949; -fx-font-size: 18px;";
	
	private void updateGui() {
		this.navItemText.setText(this.text);
		if(this.isActive && this.isRed) {
			this.navItemContainer.setStyle(ACTIVE_RED_ITEM_STYLE);
			this.navItemText.setStyle(ACTIVE_TEXT_STYLE);
		}
		else if(!this.isActive && this.isRed) {
			this.navItemContainer.setStyle(IDLE_ITEM_STYLE);
			this.navItemText.setStyle(IDLE_RED_TEXT_STYLE);
		}
		else if(this.isActive && !this.isRed) {
			this.navItemContainer.setStyle(ACTIVE_ITEM_STYLE);
			this.navItemText.setStyle(ACTIVE_TEXT_STYLE);
		}
		else {
			this.navItemContainer.setStyle(IDLE_ITEM_STYLE);
			this.navItemText.setStyle(IDLE_TEXT_STYLE);
		}
	}
	
	public void navItemEntered() {
		if(this.isRed) {
			this.navItemContainer.setStyle(ACTIVE_RED_ITEM_STYLE);
			this.navItemText.setStyle(ACTIVE_TEXT_STYLE);
		}
		else {
			this.navItemContainer.setStyle(ACTIVE_ITEM_STYLE);
			this.navItemText.setStyle(ACTIVE_TEXT_STYLE);
		}
	}
	
	public void navItemExited() {
		this.updateGui();
	}
}
