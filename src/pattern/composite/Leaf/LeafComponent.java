package pattern.composite.Leaf;

import javafx.scene.image.Image;
import pattern.composite.ComponentInterface;
import pattern.composite.ComponentType;

public abstract class LeafComponent implements ComponentInterface {
	protected String model;
	protected String manufacturer;
	protected double price;
	protected ComponentType type;
	protected Image pic;
	
	public LeafComponent(String model, String manufacturer, double price, ComponentType type, String imagePath) {
		this.model = model;
		this.manufacturer = manufacturer;
		this.price = price;
		this.type = type;
		this.pic = new Image(imagePath);
	}
	
	@Override
	public double getPrice() {
		return price;
	}
	
	@Override
	public String getModel() {
		return model;
	}
	
	@Override
	public String getManufacturer() {
		return manufacturer;
	}
	
	@Override
	public ComponentType getType() {
		return type;
	}
	
	@Override
	public Image getPic() {
		return pic;
	}
}
