package pattern.controller;

import javafx.scene.layout.FlowPane;
import pattern.facade.Facade;

import java.io.File;

public class RootController {
	
	public FlowPane content_pane;
	
	public void initialize() {
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "pattern" + File.separator + "resources";
		content_pane.getChildren().addAll(Facade.exploreDirectory(path));
	}
}