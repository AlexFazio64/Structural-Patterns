package pattern.composite.Leaf;

import pattern.composite.ComponentType;

public class FAN extends LeafComponent {
	public FAN(String model, String manufacturer, double price, String imagePath) {
		super(model, manufacturer, price, ComponentType.COOLING, imagePath);
	}
}
