package gui.controller;

import database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Vehicle;

import java.io.IOException;
import java.util.Optional;

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
		System.out.println(productionInput.getValue());	//TODO change to only input year
		System.out.println(nextInspectionInput.getValue());
		
		Vehicle newVehicle = new Vehicle(brandInput.getText(), registrationInput.getText(), productionInput.getValue(), nextInspectionInput.getValue());
		
		Database.getInstance().save(newVehicle);
		
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Przypisz instruktora");
		alert.setHeaderText("Pomyślnie zarejestrowano pojazd");
		alert.setContentText("Czy chcesz przypisać pojazd do instruktora? ");
		
		Optional<ButtonType> action = alert.showAndWait();
		
		try {
			if(action.isPresent()) {
				if (action.get() == ButtonType.OK) {
					MainMenu.changeScene(e, "../assignInstructorToCar.fxml");
				} else if (action.get() == ButtonType.CANCEL) {
					MainMenu.returnToMainMenu(e);
				}
			}
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
	
	public void onCancel(ActionEvent e) throws IOException {
		MainMenu.returnToMainMenu(e);
	}
}
