package pattern;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/root.fxml"));
		Stage mainStage = new Stage();
		mainStage.setScene(new Scene(loader.load()));
		mainStage.setTitle("TITLE");
		mainStage.setResizable(false);
		mainStage.setWidth(600);
		mainStage.setHeight(400);
		mainStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
