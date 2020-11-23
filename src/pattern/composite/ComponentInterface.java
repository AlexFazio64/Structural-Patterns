package pattern.composite;

import javafx.scene.image.Image;

public interface ComponentInterface {
	double getPrice();
	
	String getModel();
	
	String getManufacturer();
	
	ComponentType getType();
	
	Image getPic();
	
	default String printInfo() {
		return "Model: " + getModel() + "\n" + "Manufacturer: " + getManufacturer() + "\n" + "Component type: " + getType() + "\n" + "Total price: " + getPrice();
	}
}
