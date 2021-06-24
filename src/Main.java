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


/**
 *
 */
public class Main extends Application {
	/**
	 * @param args arguments from running program
	 */
	public static void main(String[] args) {
		//Run GUI window
		launch(args);
	}
	
	/**
	 * @param primaryStage Initial stage created through launching application
	 */
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
	
	/**
	 * @throws Exception super.stop() returns Exception
	 */
	@Override
	public void stop() throws Exception {
		Database.getInstance().close();
		
		super.stop();
	}
}
