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

public class AssignInstructorController implements Initializable {
	
	@FXML
	private ChoiceBox<Instructor> instructorChoice;
	@FXML
	private ChoiceBox<Vehicle> vehicleChoice;
	
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
