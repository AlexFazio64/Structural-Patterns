package pattern.composite.Leaf;

import pattern.composite.ComponentType;

public class GPU extends LeafComponent {
	public GPU(String model, String manufacturer, double price, String imagePath) {
		super(model, manufacturer, price, ComponentType.GPU, imagePath);
	}
}
