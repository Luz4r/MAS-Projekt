package gui.controller;

import database.Database;
import gui.InstructorCell;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Instructor;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class InstructorListController implements Initializable {
	
	@FXML
	private ListView<Instructor> instructorList;
	
	private Instructor currentInstructor;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<Instructor> instructors = Database.getInstance().getAll(Instructor.class);
		
		if(instructors.isEmpty()) return;
		
		instructorList.setCellFactory(instructorListView -> new InstructorCell());
		
		instructorList.getItems().addAll(instructors);
		
		instructorList.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> {
					currentInstructor = instructorList.getSelectionModel().getSelectedItem();
					try {
						VehicleListController controller = MainMenu.changeScene(
								(Stage)instructorList.getScene().getWindow(), "../vehicleList.fxml"
						);
						controller.forwardInstructor(currentInstructor);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
		);
	}
	
	public void onBackToMenu(ActionEvent e) throws IOException {
		MainMenu.returnToMainMenu(e);
	}
}
