package pattern.proxy;

import javafx.scene.image.Image;
import pattern.Client;

public class FileProxy extends StandaloneFile {
	private static Image graphic = null;
	private GraphicFile file;
	
	public FileProxy(String path) {
		super(path);
		if ( graphic == null ) {
			graphic = new Image(Client.res("icons/graphic.png"));
		}
		super.icon = graphic;
		file = null;
	}
	
	@Override
	public void open() {
		if ( file == null ) {
			file = new GraphicFile(super.path);
			icon = file.getIcon();
		}
		file.open();
	}
}
