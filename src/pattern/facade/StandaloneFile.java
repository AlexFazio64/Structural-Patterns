package pattern.facade;

import javafx.scene.image.Image;
import pattern.Client;

public abstract class StandaloneFile {
	private static Image audio = null;
	private static Image graphic = null;
	private static Image unknown = null;
	
	String info;
	String path;
	Image icon;
	
	StandaloneFile(String type, String path) {
		this.path = path;
		String[] tok = path.split("/");
		this.info = tok[tok.length - 1].replace("%20", " ");
		
		switch (type) {
			case "audio":
				if ( audio == null ) {
					audio = new Image(Client.res("icons/audio.png"));
				}
				icon = audio;
				break;
			case "graphic":
				if ( graphic == null ) {
					graphic = new Image(Client.res("icons/graphic.png"));
				}
				icon = graphic;
				break;
			default:
				if ( unknown == null ) {
					unknown = new Image(Client.res("unknown.png"));
				}
				icon = unknown;
		}
	}
	
	public String getInfo() {
		return info;
	}
	
	public Image getIcon() {
		return icon;
	}
	
	public abstract void open();
}
