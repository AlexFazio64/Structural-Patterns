package pattern.decorator;

import javafx.scene.image.Image;

public class ConcretePizza extends Component {
	public ConcretePizza(Image pic, double price) {
		this.base = pic;
		this.price = price;
	}
}
