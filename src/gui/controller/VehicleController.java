package gui.controller;

import database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Vehicle;

public class VehicleController {
	
	@FXML
	private TextField brandInput;
	@FXML
	private TextField registrationInput;
	@FXML
	private DatePicker productionInput;
	@FXML
	private DatePicker nextInspectionInput;
	
	public void onApprove(ActionEvent e){
		System.out.println("approve");
		System.out.println(brandInput.getText());
		System.out.println(registrationInput.getText());
		System.out.println(productionInput.getValue());
		System.out.println(nextInspectionInput.getValue());
		
		Vehicle newVehicle = new Vehicle(brandInput.getText(), registrationInput.getText(), productionInput.getValue(), nextInspectionInput.getValue());
		
		Database.getInstance().save(newVehicle);
	}
	
	public void onCancel(ActionEvent e){
		System.out.println("cancel");
		
		((Stage)brandInput.getScene().getWindow()).close(); // TODO return to scene with instructors
	}
}
