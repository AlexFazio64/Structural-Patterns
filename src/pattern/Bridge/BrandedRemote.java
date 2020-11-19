package pattern.Bridge;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class BrandedRemote extends AbstractRemote {
	double old;
	CheckBox enabled;
	
	public BrandedRemote(int type, CheckBox enabled, GraphicsContext graphicsContext2D, ProgressBar volumeBar, Label channel) {
		super(type, graphicsContext2D, volumeBar, channel);
		old = 0.0;
		this.enabled = enabled;
		enabled.setIndeterminate(false);
		enabled.setSelected(true);
		labels = new String[]{"🔌", "🔈X", "🔉-", "🔊+", "⏪", "⏩"};
	}
	
	@Override
	public void mute() {
		if ( !device.getPower() ) {
			return;
		}
		
		if ( enabled.isSelected() ) {
			enabled.setSelected(false);
			old = device.getVolume();
			device.setVolume(0.0);
			volume.setDisable(true);
		} else {
			enabled.setSelected(true);
			device.setVolume(old);
			volume.setDisable(false);
		}
	}
	
	@Override
	public void volumeUp() {
		if ( enabled.isSelected() ) {
			super.volumeUp();
		}
	}
	
	@Override
	public void volumeDown() {
		if ( enabled.isSelected() ) {
			super.volumeDown();
		}
	}
}
