package pattern.composite.Leaf;

import pattern.composite.ComponentType;

public class CPU extends LeafComponent {
	public CPU(String model, String manufacturer, double price, String imagePath) {
		super(model, manufacturer, price, ComponentType.CPU, imagePath);
	}
}
