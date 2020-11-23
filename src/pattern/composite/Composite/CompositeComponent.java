package pattern.composite.Composite;

import javafx.scene.image.Image;
import pattern.composite.ComponentInterface;
import pattern.composite.ComponentType;

import java.util.ArrayList;

public abstract class CompositeComponent implements ComponentInterface {
	protected String model;
	protected String manufacturer;
	protected double price;
	protected ComponentType type;
	protected Image pic;
	protected ArrayList<ComponentInterface> children;
	
	public CompositeComponent(String model, String manufacturer, double price, ComponentType type, String imagePath, int slots) {
		this.model = model;
		this.manufacturer = manufacturer;
		this.price = price;
		this.type = type;
		this.pic = new Image(imagePath);
		children = new ArrayList<>(slots);
	}
	
	@Override
	public double getPrice() {
		double p = price;
		for (ComponentInterface c: children) {
			p += c.getPrice();
		}
		return p;
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
	
	public abstract ComponentInterface remove(int index);
	
	public ComponentInterface getChild(int index) {
		return children.get(index);
	}
	
	public abstract boolean addComponent(ComponentInterface component);
	
	protected int countType(ComponentType t) {
		int value = 0;
		for (ComponentInterface c: children) {
			value += c.getType() == t ? 1 : 0;
		}
		return value;
	}
}
