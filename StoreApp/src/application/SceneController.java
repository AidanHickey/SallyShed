package application;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;

public class SceneController {

		private static final String baseScenePath = "/scenes/";
		private static Stage stage;
		private static Map<String, String> sceneFiles = new HashMap<String, String>();
 
		public SceneController() {
		}
		
		public static void setStage( Stage stage) {
			SceneController.stage = stage;
		}
		 
		public static void addScene( String sceneName, String sceneFile) {
			sceneFiles.put( sceneName, sceneFile);
		}
		 
		public static String getSceneFile( String sceneName) {
			return SceneController.sceneFiles.get(sceneName);
		}
		 
		public static void switchToScene( String sceneName) throws IOException {
			Scene scene = getScene( SceneController.sceneFiles.get(sceneName));
			Node newMenuItem = scene.getRoot().lookup(".menu-item."+sceneName);
			Node oldMenuItem = scene.getRoot().lookup(".menu-item.current");
			if( newMenuItem != null)
				newMenuItem.getStyleClass().add("current");
			
			if( oldMenuItem != null)
				oldMenuItem.getStyleClass().removeIf(style -> style.equals("current"));
			
			stage.setScene(scene);
		}
	 
		public static Scene getScene( String sceneFile) throws IOException {
			URL url = Main.class.getResource( SceneController.baseScenePath + sceneFile);
			FXMLLoader loader = new FXMLLoader( url);
			return new Scene(loader.load());
		}
}