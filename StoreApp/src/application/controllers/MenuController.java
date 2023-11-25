package application.controllers;

import java.io.IOException;

import application.SceneController;
import javafx.scene.input.MouseEvent;

public class MenuController {
	
	public MenuController() {}
	
	public void go(MouseEvent event) {
		String itemID = event.getPickResult().getIntersectedNode().getId();
		
		if(itemID != null)
			try {
				SceneController.switchToScene(itemID);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}