package gui.controller;

import database.Database;
import gui.InstructorCell;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import model.Instructor;

import java.awt.event.ActionEvent;
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
		
//		instructorList.setCellFactory(param -> new ListCell<Instructor>(){
//			@Override
//			protected void updateItem(Instructor inst, boolean isEmpty){
//				super.updateItem(inst, isEmpty);
//				if(isEmpty || inst == null || inst.getFirstName() == null){
//					setText("");
//				} else{
//					setText(inst.getFirstName() + " " + inst.getLastName() + "\t\t" + inst.getPhoneNumber() + "\t\t"
//							+ inst.getEMail() + "\t\t" + inst.getBirthDate() + "\t\t" + inst.getWorkingHours() + "\t\t"
//							+ inst.getSalary());
//				}
//			}
//		});
		
		instructorList.setCellFactory(instructorListView -> new InstructorCell());
		
		instructorList.getItems().addAll(instructors);
		
		instructorList.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> currentInstructor = instructorList.getSelectionModel().getSelectedItem()
		);
	}
	
	public void onBackToMenu(javafx.event.ActionEvent e) {
		System.out.println("Back to menu");
	}
}
