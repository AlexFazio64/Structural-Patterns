package pattern.controller;

import javafx.scene.layout.HBox;
import pattern.composite.GraphicalComponent;

public class MoboViewController {
	public HBox hbox;
	
	public void init(GraphicalComponent... list) {
		hbox.getChildren().addAll(list);
	}
}
