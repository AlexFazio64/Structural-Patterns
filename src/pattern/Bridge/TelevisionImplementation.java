package pattern.Bridge;

import javafx.scene.image.Image;

abstract class TelevisionImplementation {
	private Double volume;
	private Integer channel;
	private Boolean power;
	protected Image brand;
	
	TelevisionImplementation() {
		this.volume = 0.0;
		this.channel = 0;
		this.power = false;
		setImage();
	}
	
	public Double getVolume() {
		return volume;
	}
	
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	
	public Integer getChannel() {
		return channel;
	}
	
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	
	public Boolean getPower() {
		return power;
	}
	
	public void setPower(Boolean power) {
		this.power = power;
	}
	
	public Image getBrand() {
		return brand;
	}
	
	protected abstract void setImage();
}
