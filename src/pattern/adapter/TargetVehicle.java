package pattern.adapter;

import javafx.scene.control.TextArea;

public abstract class TargetVehicle {
	protected Integer currentSpeed;
	protected boolean engine;
	protected TextArea log;
	
	public TargetVehicle(TextArea textArea) {
		currentSpeed = 0;
		engine = false;
		this.log = textArea;
	}
	
	public abstract void accelerate(int boost);
	
	public abstract void decelerate(int decrease);
	
	public abstract void startup();
	
	public abstract void shutdown();
}
