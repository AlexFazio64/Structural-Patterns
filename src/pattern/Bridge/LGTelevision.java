package pattern.Bridge;

import javafx.scene.image.Image;

public class LGTelevision extends TelevisionImplementation {
	@Override
	protected void setImage() {
		this.brand = new Image(getClass().getResource("../resources/lg.png").toString());
	}
}
