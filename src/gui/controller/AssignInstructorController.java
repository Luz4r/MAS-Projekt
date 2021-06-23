package gui.controller;

import database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import model.Instructor;
import model.InstructorVehicle;
import model.Vehicle;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AssignInstructorController implements Initializable {
	
	@FXML
	private ChoiceBox<Instructor> instructorChoice;
	@FXML
	private ChoiceBox<Vehicle> vehicleChoice;
	
	Database db;
	
	public void onApprove(ActionEvent e){
		Instructor selectedInstructor = instructorChoice.getValue();
		Vehicle selectedVehicle = vehicleChoice.getValue();
		
		InstructorVehicle insVeh = new InstructorVehicle(LocalDate.now());
		insVeh.addInstructor(selectedInstructor);
		insVeh.addVehicle(selectedVehicle);
		
		db.save(insVeh);
		db.save(selectedInstructor);
		db.save(selectedVehicle);
	}
	
	public void onCancel(ActionEvent e){
		System.out.println("cancel");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		db = Database.getInstance();
		
		instructorChoice.getItems().addAll(db.getAll(Instructor.class));
		
		vehicleChoice.getItems().addAll(db.getAll(Vehicle.class));
	}
}