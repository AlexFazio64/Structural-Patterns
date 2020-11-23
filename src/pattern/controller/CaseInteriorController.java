package pattern.controller;

import javafx.scene.layout.HBox;
import pattern.composite.GraphicalComponent;

public class CaseInteriorController {
	public HBox hbox;
	
	public void init(GraphicalComponent... list) {
		hbox.getChildren().addAll(list);
	}
}
