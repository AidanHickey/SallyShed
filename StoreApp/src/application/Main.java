package application;
 
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
 
 @Override
 public void start(Stage stage) {
	 SceneController.setStage(stage);
	 SceneController.addScene( "home", "home window.fxml"); //loads the scene of name and file type
	 SceneController.addScene( "products", "products.fxml");
	 SceneController.addScene( "checkout","checkOutWindow.fxml" );
	 
	 
	 try {
		 SceneController.switchToScene("home"); // change here set the starting page
		 stage.show();
		 
	 } catch(IOException e) {
		 e.printStackTrace();
	 }
 } 

 public static void main(String[] args) {
  launch(args);
 }
}