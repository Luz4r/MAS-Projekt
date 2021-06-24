package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu {
	
	public void onListInstructors(ActionEvent e) throws IOException {
		changeScene(e, "../instructorList.fxml");
	}
	
	public void onAddVehicle(ActionEvent e) throws IOException{
		changeScene(e, "../addVehicle.fxml");
	}
	
	public void onAssignInstructor(ActionEvent e) throws IOException{
		changeScene(e, "../assignInstructorToCar.fxml");
	}
	
	public static <T> T changeScene(ActionEvent e, String uri) throws IOException {
		return changeScene((Stage)((Node)e.getSource()).getScene().getWindow(), uri);
	}
	
	public static <T>  T changeScene(Stage stage, String uri) throws IOException {
		FXMLLoader loader = new FXMLLoader(MainMenu.class.getResource(uri));
		Parent root = loader.load();
		
		T controller = loader.getController();
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		return controller;
	}
	
	public static void returnToMainMenu(ActionEvent e) throws IOException{
		changeScene(e, "../mainMenu.fxml");
	}
}
