package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Main menu. Javafx controller managing main menu scene and also help changing scene in other scenes.
 */
public class MainMenu {
	
	/**
	 * On list instructors. When pressing button to show instructor list.
	 *
	 * @param e the event
	 * @throws IOException the io exception
	 */
	public void onListInstructors(ActionEvent e) throws IOException {
		changeScene(e, "../instructorList.fxml");
	}
	
	/**
	 * On add vehicle. When pressing button to add new vehicle.
	 *
	 * @param e the event
	 * @throws IOException the io exception
	 */
	public void onAddVehicle(ActionEvent e) throws IOException{
		changeScene(e, "../addVehicle.fxml");
	}
	
	/**
	 * On assign instructor. When pressing button to assign instructor to vehicle.
	 *
	 * @param e the event
	 * @throws IOException the io exception
	 */
	public void onAssignInstructor(ActionEvent e) throws IOException{
		changeScene(e, "../assignInstructorToCar.fxml");
	}
	
	/**
	 * Change scene. To allow easily to change scenes from other scenes.
	 *
	 * @param <T> the type parameter
	 * @param e   the event
	 * @param uri the uri
	 * @return the t
	 * @throws IOException the io exception
	 */
	public static <T> T changeScene(ActionEvent e, String uri) throws IOException {
		return changeScene((Stage)((Node)e.getSource()).getScene().getWindow(), uri);
	}
	
	/**
	 * Change scene. To allow easily to change scenes from other scenes.
	 *
	 * @param <T>   type of class of controller to return
	 * @param stage the stage to where load scene
	 * @param uri   the uri of scene to load
	 * @return controller
	 * @throws IOException the io exception
	 */
	public static <T>  T changeScene(Stage stage, String uri) throws IOException {
		FXMLLoader loader = new FXMLLoader(MainMenu.class.getResource(uri));
		Parent root = loader.load();
		
		T controller = loader.getController();
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		return controller;
	}
	
	/**
	 * Return to main menu. Specified for scenes where user want to return to main menu.
	 *
	 * @param e the event to get stage for loading scene
	 * @throws IOException the io exception
	 */
	public static void returnToMainMenu(ActionEvent e) throws IOException{
		changeScene(e, "../mainMenu.fxml");
	}
}
