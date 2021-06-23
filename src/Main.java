import database.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Instructor;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main extends Application {
	public static void main(String[] args) {
//			Instructor ins1 = new Instructor("Krzysztof", "Skowronek", "654789123",
//					"krz.sko@gmail.com", LocalDate.of(1990, 2, 5),
//					5000.0d, Stream.of("9:00 - 17:00").collect(Collectors.toSet()), false);
//			Instructor ins2 = new Instructor("Nikodem", "Dyzma", "456123789",
//					"nik.dyz@gmail.com", LocalDate.of(1968, 11, 25),
//					6000.0d, Stream.of("8:00 - 16:00").collect(Collectors.toSet()), false);
//
//		Database db = Database.getInstance();
//
//		db.save(ins1);
//		db.save(ins2);

//			// Read from DB
//			session = sessionFactory.openSession();
//			session.beginTransaction();
//			List<Instructor> instructorsFromDb = session.createQuery( "from Instructor" ).list();
//
//			for (Instructor instructor:
//				 instructorsFromDb) {
//				System.out.println(instructor.getInstructorType());
//			}
		
		//Run GUI window
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try{
			Parent root = FXMLLoader.load(getClass().getResource("gui/instructorList.fxml")); //addVehicle    assignInstructorToCar   instructorList
			primaryStage.setScene(new Scene(root, 800, 600));
			primaryStage.setTitle("Elka");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() throws Exception {
		Database.getInstance().close();
		
		super.stop();
	}
}
