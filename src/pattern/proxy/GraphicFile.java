package pattern.proxy;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class GraphicFile extends StandaloneFile {
	Stage preview;
	
	public GraphicFile(String path) {
		super(path);
		super.icon = new Image(path);
		
		preview = new Stage(StageStyle.UTILITY);
		preview.setTitle(info);
		preview.setResizable(false);
		preview.setScene(new Scene(new BorderPane(new ImageView(icon))));
		preview.setWidth(icon.getWidth() + 50);
		preview.setHeight(icon.getHeight() + 50);
	}
	
	@Override
	public void open() {
		if ( !preview.isShowing() ) {
			preview.show();
		} else {
			preview.close();
		}
	}
}
