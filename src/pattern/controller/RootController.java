package pattern.controller;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import pattern.Bridge.AbstractRemote;
import pattern.Bridge.BrandedRemote;

import java.util.Arrays;
import java.util.List;

import static pattern.Bridge.AbstractRemote.SAMSUNG;

public class RootController {
	public Canvas pic;
	public Label channel;
	public HBox volumeBox;
	public ProgressBar volumeBar;
	public Label remoteName;
	public Label power;
	public Label mute;
	public Label volUp;
	public Label volDown;
	public Label previous;
	public Label next;
	public CheckBox enabled;
	
	AbstractRemote remote;
	
	public void initialize() {
		GraphicsContext gc = pic.getGraphicsContext2D();
		Image tv = new Image(getClass().getResource("../resources/tv.png").toString());
		gc.drawImage(tv, 0, 0);

//		remote = new BrandedRemote(LG, enabled, gc, volumeBar, channel);
//		remote = new GenericRemote(LG, "XIAOMI", .03, 10, gc, volumeBar, channel);
//		remote = new GenericRemote(SAMSUNG, "XIAOMI", .03, 10, gc, volumeBar, channel);
		remote = new BrandedRemote(SAMSUNG, enabled, gc, volumeBar, channel);
		
		List<Label> asList = Arrays.asList(power, mute, volDown, volUp, previous, next);
		for (int i = 0; i < asList.size(); i++) {
			asList.get(i).setText(remote.getLabels()[i]);
		}
		
		remoteName.setText(remote.getBrand());
	}
	
	
	public void mute(MouseEvent mouseEvent) {
		remote.mute();
	}
	
	public void volUp(MouseEvent mouseEvent) {
		remote.volumeUp();
	}
	
	public void volDown(MouseEvent mouseEvent) {
		remote.volumeDown();
	}
	
	public void power(MouseEvent mouseEvent) {
		remote.power();
	}
	
	public void next(MouseEvent mouseEvent) {
		remote.channelUp();
	}
	
	public void prev(MouseEvent mouseEvent) {
		remote.channelDown();
	}
}
