package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import model.Instructor;
import sun.plugin2.message.Conversation;

import java.io.IOException;

public class InstructorCell extends ListCell<Instructor> {
	
	@FXML
	private Label nameLabel;
	@FXML
	private Label phoneLabel;
	@FXML
	private Label emailLabel;
	@FXML
	private Label birthDateLabel;
	@FXML
	private Label workingHoursLabel;
	@FXML
	private Label salaryLabel;
	
	private FXMLLoader loader;
	
	@Override
	protected void updateItem(Instructor inst, boolean isEmpty) {
		super.updateItem(inst, isEmpty);
		
		if(isEmpty || inst == null){
			setText(null);
			setGraphic(null);
		} else{
			if(loader == null) {
				loader = new FXMLLoader(getClass().getResource("listCell.fxml"));
				loader.setController(this);
				try {
					loader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			nameLabel.setText(inst.getFirstName() + " " + inst.getLastName());
			phoneLabel.setText(inst.getPhoneNumber());
			emailLabel.setText(inst.getEMail());
			birthDateLabel.setText(inst.getBirthDate().toString());
			workingHoursLabel.setText(inst.getWorkingHours().toString());
			salaryLabel.setText(String.valueOf(inst.getSalary()));
			
			setText(null);
			setGraphic(loader.getRoot());
		}
	}
}
