package pattern;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Client extends Application {
	public static Window stage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/root.fxml"));
		primaryStage.setScene(new Scene(loader.load()));
		primaryStage.setTitle("Proxy File Explorer");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static String res(String name) {
		return Client.class.getResource("resources/" + name).toString();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
