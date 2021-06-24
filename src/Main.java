import database.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * This is an application for driver education school. It helps managing every vehicle, trainees and instructors that are
 * registered in this school. Main class where gui and whole program starts.
 */
public class Main extends Application {
	/**
	 * The entry point of application.
	 *
	 * @param args arguments from running program
	 */
	public static void main(String[] args) {
		//Run GUI window
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try{
			Parent root = FXMLLoader.load(getClass().getResource("gui/mainMenu.fxml"));
			primaryStage.setScene(new Scene(root, 800, 600));
			primaryStage.setTitle("Szkoła kształcenia kierowców \"Elka\"");
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
