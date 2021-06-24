package gui.controller;

import database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import model.Instructor;
import model.Vehicle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Assign instructor controller. Controller used in scene where user can assign instructor to car.
 */
public class AssignInstructorController implements Initializable {
	
	@FXML
	private ChoiceBox<Instructor> instructorChoice;
	@FXML
	private ChoiceBox<Vehicle> vehicleChoice;
	
	/**
	 * On clicking on button "approve", adds every needed association and saves it to database.
	 *
	 * @param e the event
	 */
	public void onApprove(ActionEvent e){
		Instructor selectedInstructor = instructorChoice.getValue();
		Vehicle selectedVehicle = vehicleChoice.getValue();
		
		selectedInstructor.assignToVehicle(selectedVehicle);
		
		try {
			MainMenu.returnToMainMenu(e);
		} catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * Return to main menu when pressing cancel button.
	 *
	 * @param e the event
	 * @throws IOException the io exception
	 */
	public void onCancel(ActionEvent e) throws IOException {
		MainMenu.returnToMainMenu(e);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Database db = Database.getInstance();
		
		instructorChoice.getItems().addAll(db.getAll(Instructor.class));
		
		vehicleChoice.getItems().addAll(db.getAll(Vehicle.class));
	}
}
