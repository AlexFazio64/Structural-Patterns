package pattern.facade;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class FilePacker {
	public static BorderPane wrapFile(StandaloneFile f) {
		Label name = new Label(f.getInfo());
		ImageView wrapper = new ImageView(f.getIcon());
		wrapper.setOnMouseClicked(e -> f.open());
		BorderPane wrappedFile = new BorderPane();
		wrappedFile.setCenter(wrapper);
		wrappedFile.setBottom(name);
		return wrappedFile;
	}
}
