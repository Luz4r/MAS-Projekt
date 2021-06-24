package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Instructor;
import model.InstructorVehicle;

import java.io.IOException;

public class VehicleListController {
	
	@FXML
	private Label instructorLabel;
	@FXML
	private ListView<String> vehicleList;
	
	public void onBackToMenu(ActionEvent e) {
		try {
			MainMenu.changeScene(e, "../instructorList.fxml");
		} catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public void forwardInstructor(Instructor instructor){
		instructorLabel.setText(instructor.toString());
		
		for(InstructorVehicle vehicle : instructor.getVehicles()){
			vehicleList.getItems().add(vehicle.getVehicle().toString());
		}
	}
}
