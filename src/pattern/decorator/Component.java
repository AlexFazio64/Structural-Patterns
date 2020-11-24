package pattern.decorator;

import javafx.scene.image.Image;

public abstract class Component {
	protected Image base;
	protected double price;
	
	public Image getImage() {
		return base;
	}
	
	public double getPrice() {
		return price;
	}
}
