package GUI;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static Stage stg;
	
	@Override
	public void start(Stage primaryStage) 
	{
		try {
			
			stg = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("StartingPage.fxml"));
			Scene scene = new Scene(root,912,567);
			primaryStage.setTitle("ATM");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeScene(String fxml) 
	{
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource(fxml));
			stg.getScene().setRoot(root);
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
