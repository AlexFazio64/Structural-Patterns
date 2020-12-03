package pattern.proxy;

import javafx.scene.image.Image;

public abstract class StandaloneFile {
	String info;
	String path;
	Image icon;
	
	public StandaloneFile(String path) {
		this.path = path;
		String[] tok = path.split("/");
		this.info = tok[tok.length - 1].replace("%20", " ");
	}
	
	public String getInfo() {
		return this.info + "\t - " + (int) icon.getWidth() + "x" + (int) icon.getHeight();
	}
	
	public Image getIcon() {
		return icon;
	}
	
	public abstract void open();
}
