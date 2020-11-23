package pattern.composite;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import pattern.Client;

public class GraphicalComponent extends ImageView {
	private ComponentInterface component;
	
	public GraphicalComponent(ComponentInterface component, Scene child, Scene parent) {
		super(component.getPic());
		this.component = component;
		this.setOnMouseClicked(e -> {
			if ( e.getButton() == MouseButton.PRIMARY ) {
				if ( child != null ) {
					Client.primary.setScene(child);
				}
			}
			if ( e.getButton() == MouseButton.SECONDARY ) {
				if ( parent != null ) {
					Client.primary.setScene(parent);
				}
			}
			if ( e.getButton() == MouseButton.MIDDLE ) {
				Client.info_controller.getInfo(this, this.getParent().getScene());
				Client.primary.setScene(Client.component_info);
			}
		});
		
	}
	
	public ComponentInterface getComponent() {
		return component;
	}
}
