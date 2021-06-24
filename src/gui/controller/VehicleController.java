package gui.controller;

import database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Vehicle;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class VehicleController implements Initializable {
	
	@FXML
	private TextField brandInput;
	@FXML
	private TextField registrationInput;
	@FXML
	private TextField productionInput;
	@FXML
	private DatePicker nextInspectionInput;
	
	public void onApprove(ActionEvent e){
		Vehicle newVehicle = new Vehicle(brandInput.getText(), registrationInput.getText(),
				LocalDate.of(Integer.parseInt(productionInput.getText()), 1, 1),
				nextInspectionInput.getValue());
		
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		UnaryOperator<TextFormatter.Change> filter = change -> {
			String text = change.getText();
			
			if (text.matches("\\d*")) {
				return change;
			}
			
			return null;
		};
		TextFormatter<String> textFormatter = new TextFormatter<String>(filter);
		productionInput.setTextFormatter(textFormatter);
	}
}
