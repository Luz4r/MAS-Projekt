package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Instructor;
import model.InstructorVehicle;

import java.io.IOException;

/**
 * The type Vehicle list controller. Used in scene when listing vehicles of selected instructor.
 */
public class VehicleListController {
	
	@FXML
	private Label instructorLabel;
	@FXML
	private ListView<String> vehicleList;
	
	/**
	 * On back to menu. When return to menu button pressed, return to main menu scene.
	 *
	 * @param e the e
	 */
	public void onBackToMenu(ActionEvent e) {
		try {
			MainMenu.changeScene(e, "../instructorList.fxml");
		} catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * Forward instructor get selected instructor from instructor list scene and list every vehicle associated with
	 * selected instructor.
	 *
	 * @param instructor  selected instructor
	 */
	public void forwardInstructor(Instructor instructor){
		instructorLabel.setText(instructor.toString());
		
		for(InstructorVehicle vehicle : instructor.getVehicles()){
			vehicleList.getItems().add(vehicle.getVehicle().toString());
		}
	}
}
