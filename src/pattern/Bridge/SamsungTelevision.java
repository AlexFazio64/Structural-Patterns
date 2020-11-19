package pattern.Bridge;

import javafx.scene.image.Image;

public class SamsungTelevision extends TelevisionImplementation {
	@Override
	protected void setImage() {
		this.brand = new Image(getClass().getResource("../resources/samsung.png").toString());
	}
}
