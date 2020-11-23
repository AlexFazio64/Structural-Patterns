package pattern.composite.Leaf;

import pattern.composite.ComponentType;

public class RAM extends LeafComponent {
	public RAM(String model, String manufacturer, double price, String imagePath) {
		super(model, manufacturer, price, ComponentType.RAM, imagePath);
	}
}
