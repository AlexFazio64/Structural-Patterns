package pattern.composite.Composite;

import pattern.composite.ComponentInterface;
import pattern.composite.ComponentType;

public class MotherBoard extends CompositeComponent {
	private int max_sockets;
	private int max_ram_slots;
	private int max_pci_e;
	private int max_fans;
	
	public MotherBoard(String model, String manufacturer, double price, String imagePath, int sockets, int ram_slots, int pci_e_slots, int fan_headers) {
		super(model, manufacturer, price, ComponentType.MOBO, imagePath, sockets + ram_slots + pci_e_slots + fan_headers);
		this.max_sockets = sockets;
		this.max_ram_slots = ram_slots;
		this.max_pci_e = pci_e_slots;
		this.max_fans = fan_headers;
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
			case CPU:
				if ( countType(ComponentType.CPU) < max_sockets ) {
					++max_sockets;
					break;
				}
				return false;
			case GPU:
				if ( countType(ComponentType.GPU) < max_pci_e ) {
					++max_pci_e;
					break;
				}
				return false;
			case RAM:
				if ( countType(ComponentType.RAM) < max_ram_slots ) {
					++max_ram_slots;
					break;
				}
				return false;
			default:
				return false;
		}
		
		return children.add(component);
	}
	
	@Override
	public ComponentInterface remove(int index) {
		ComponentInterface comp = children.remove(index);
		switch (comp.getType()) {
			case COOLING:
				--max_fans;
				break;
			case CPU:
				--max_sockets;
				break;
			case GPU:
				--max_pci_e;
				break;
			case RAM:
				--max_ram_slots;
				break;
		}
		
		return comp;
	}
}
