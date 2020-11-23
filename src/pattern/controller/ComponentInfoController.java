package pattern.controller;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import pattern.Client;
import pattern.composite.GraphicalComponent;

public class ComponentInfoController {
	public Label typeLbl;
	public BorderPane picPane;
	public Label modelLbl;
	public Label manufacturerLbl;
	public Label priceLbl;
	
	public void getInfo(GraphicalComponent component, Scene previous) {
		typeLbl.setText(String.valueOf(component.getComponent().getType()));
		ImageView copy = new ImageView(component.getImage());
		copy.setOnMouseClicked(e -> {
			if ( e.getButton() == MouseButton.SECONDARY ) {
				Client.primary.setScene(previous);
			}
		});
		picPane.setCenter(copy);
		modelLbl.setText("Model: " + component.getComponent().getModel());
		manufacturerLbl.setText("Brand: " + component.getComponent().getManufacturer());
		priceLbl.setText("Total Price: " + component.getComponent().getPrice() + "$");
	}
}
