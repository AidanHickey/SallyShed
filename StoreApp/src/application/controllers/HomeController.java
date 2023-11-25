package application.controllers;

import java.io.IOException;

import application.SceneController;
import javafx.scene.input.MouseEvent;

public class HomeController {
	
	public HomeController() {
	}
	
	public void switchToProducts(MouseEvent event) {
		
		try {
			SceneController.switchToScene("products");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}