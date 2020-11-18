package pattern.adapter;

import javafx.scene.control.TextArea;

public class AnimalVehicle extends TargetVehicle {
	private AdapteeAnimal adaptee;
	private boolean mounted;
	
	public AnimalVehicle(TextArea textArea) {
		super(textArea);
		adaptee = new AdapteeAnimal("Dog", "woof", true);
		mounted = false;
	}
	
	@Override
	public void accelerate(int boost) {
		if ( mounted ) {
			currentSpeed += Math.abs(boost);
			log.appendText(adaptee.type + " is a good boy: " + currentSpeed + "\n");
		} else {
			log.appendText("you are not on " + adaptee.type + "\n");
		}
		
		for (int i = 0; i < boost / 3; i++) {
			log.appendText(adaptee.pet() + "\n");
		}
	}
	
	@Override
	public void decelerate(int decrease) {
		log.appendText(adaptee.shout() + "\n");
		
		if ( mounted ) {
			currentSpeed -= Math.abs(decrease);
			log.appendText(adaptee.type + " is a naughty boy: " + currentSpeed + "\n");
		} else {
			log.appendText("you are not on " + adaptee.type + "\n");
		}
		adaptee.pet();
	}
	
	@Override
	public void startup() {
		log.appendText(adaptee.pet() + "\n");
		
		if ( adaptee.domestic && !engine ) {
			engine = true;
			mounted = true;
			log.appendText(adaptee.type + " is confused: " + adaptee.call + "?\n");
		} else {
			log.appendText("you can't mount " + adaptee.type + " now\n");
		}
	}
	
	@Override
	public void shutdown() {
		log.appendText(adaptee.pet() + "\n");
		
		if ( adaptee.domestic && engine ) {
			engine = false;
			mounted = false;
			log.appendText("you unmounted " + adaptee.type + ": " + adaptee.call + " " + adaptee.call + "!\n");
		} else {
			log.appendText("you can't mount " + adaptee.type + " now\n");
		}
	}
}
