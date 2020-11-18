package pattern.adapter;

import javafx.scene.control.TextArea;

public class Car extends TargetVehicle {
	public Car(TextArea textArea) {
		super(textArea);
	}
	
	@Override
	public void accelerate(int boost) {
		if ( engine ) {
			currentSpeed += Math.abs(boost);
			log.appendText("Accelerating: " + currentSpeed + "\n");
		} else {
			log.appendText("start it up first...\n");
		}
	}
	
	@Override
	public void decelerate(int decrease) {
		if ( engine ) {
			currentSpeed -= Math.abs(decrease);
			log.appendText("Decelerating: " + currentSpeed + "\n");
		} else {
			log.appendText("start it up first...\n");
		}
	}
	
	@Override
	public void startup() {
		if ( !engine ) {
			engine = true;
			log.appendText("Ready to go\n");
		} else {
			log.appendText("already on...\n");
		}
	}
	
	@Override
	public void shutdown() {
		if ( engine ) {
			engine = false;
			log.appendText("Ready to stop\n");
		} else {
			log.appendText("already off...\n");
		}
	}
}
