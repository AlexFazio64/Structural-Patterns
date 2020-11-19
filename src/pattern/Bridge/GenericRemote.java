package pattern.Bridge;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class GenericRemote extends AbstractRemote {
	public GenericRemote(int type, String brand, double step, int ch, GraphicsContext graphicsContext2D, ProgressBar volumeBar, Label channel) {
		super(type, graphicsContext2D, volumeBar, channel);
		this.brand = brand;
		this.volStep = step;
		this.channelMax = ch;
		labels = new String[]{"pw", "vx", "v-", "v+", "c-", "c+"};
	}
}
