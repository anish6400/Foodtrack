package main.controllers;

import java.util.Calendar;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import main.models.App;

public class TitleBarController{
	
	@FXML private Text userFullName;
	
	Calendar c = Calendar.getInstance();
	
	public void initialize(App app) {
		int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
		if(app.getUserFullName() == null) {
			this.userFullName.setText("");
		}
		else if(timeOfDay >= 0 && timeOfDay < 12){
		    this.userFullName.setText("Good Morning, " + app.getUserFullName());    
		}else if(timeOfDay >= 12 && timeOfDay < 16){
		    this.userFullName.setText("Good Afternoon, " + app.getUserFullName());  
		}else if(timeOfDay >= 16 && timeOfDay < 24){
		    this.userFullName.setText("Good Evening, " + app.getUserFullName());  
		}
	}
	
}