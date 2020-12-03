package pattern;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {
	public static String getRes(String chr) {
		return Client.class.getResource("resources/" + chr).toString();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/root.fxml"));
		primaryStage.setScene(new Scene(loader.load()));
		primaryStage.setTitle("Flyweight Demo");
		primaryStage.setResizable(false);
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
