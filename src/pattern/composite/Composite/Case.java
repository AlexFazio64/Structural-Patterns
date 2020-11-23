package pattern.composite.Composite;

import pattern.composite.ComponentInterface;
import pattern.composite.ComponentType;

public class Case extends CompositeComponent {
	
	private int max_fans;
	private int max_motherboards;
	
	public Case(String model, String manufacturer, double price, String imagePath, int fans_slots) {
		super(model, manufacturer, price, ComponentType.CASE, imagePath, fans_slots + 1);
		this.max_motherboards = 1;
		this.max_fans = fans_slots;
	}
	
	@Override
	public ComponentInterface remove(int index) {
		ComponentInterface component = children.remove(index);
		switch (component.getType()) {
			case COOLING:
				--max_fans;
				break;
			case MOBO:
				--max_motherboards;
				break;
		}
		return component;
	}
	
	@Override
	public boolean addComponent(ComponentInterface component) {
		switch (component.getType()) {
			case COOLING:
				if ( countType(ComponentType.COOLING) < max_fans ) {
					++max_fans;
					break;
				}
				return false;
			case MOBO:
				if ( countType(ComponentType.MOBO) < max_motherboards ) {
					++max_motherboards;
					break;
				}
				return false;
			default:
				return false;
		}
		return children.add(component);
	}
}
