package pattern.Bridge;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public abstract class AbstractRemote {
	public static final int LG = 1;
	public static final int SAMSUNG = 2;
	
	protected TelevisionImplementation device;
	
	protected String brand;
	protected Double volStep;
	protected Integer channelMax;
	protected String[] labels;
	
	protected final GraphicsContext gc;
	protected final ProgressBar volume;
	protected final Label channel;
	
	protected AbstractRemote(int type, GraphicsContext graphicsContext2D, ProgressBar volumeBar, Label channel) {
		if ( type == LG ) {
			this.device = new LGTelevision();
			this.brand = "LG";
			this.volStep = .1;
			this.channelMax = 99;
		} else if ( type == SAMSUNG ) {
			this.device = new SamsungTelevision();
			this.brand = "SAMSUNG";
			this.volStep = .1;
			this.channelMax = 99;
		}
		this.gc = graphicsContext2D;
		this.volume = volumeBar;
		this.channel = channel;
		
	}
	
	public void power() {
		device.setPower(!device.getPower());
		if ( device.getPower() ) {
			gc.drawImage(device.getBrand(), 0, 0);
		} else {
			gc.clearRect(8, 26, 384, 220);
		}
	}
	
	public void mute() {
		if ( !device.getPower() ) {
			return;
		}
		device.setVolume(0.0);
		volume.setProgress(0.0);
	}
	
	public void volumeDown() {
		if ( !device.getPower() ) {
			return;
		}
		device.setVolume(Math.max(0, device.getVolume() - volStep));
		volume.setProgress(device.getVolume());
	}
	
	public void volumeUp() {
		if ( !device.getPower() ) {
			return;
		}
		device.setVolume(Math.min(1, device.getVolume() + volStep));
		volume.setProgress(device.getVolume());
	}
	
	public void channelDown() {
		if ( !device.getPower() ) {
			return;
		}
		
		if ( device.getChannel().equals(0) ) {
			return;
		}
		device.setChannel(device.getChannel() - 1);
		channel.setText("CH:" + device.getChannel());
	}
	
	public void channelUp() {
		if ( !device.getPower() ) {
			return;
		}
		if ( device.getChannel().equals(channelMax) ) {
			return;
		}
		device.setChannel(device.getChannel() + 1);
		channel.setText("CH:" + device.getChannel());
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String[] getLabels() {
		return labels;
	}
}
