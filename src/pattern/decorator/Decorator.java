package pattern.decorator;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class Decorator extends Component {
	WritableImage decorated;
	double new_price;
	
	public Decorator(Component dec, Image decoration, double price) {
		Image back = dec.getImage();
		int wid, hei;
		wid = (int) back.getWidth();
		hei = (int) back.getHeight();
		WritableImage ing = new WritableImage(back.getPixelReader(), wid, hei);
		PixelReader pr = decoration.getPixelReader();
		PixelWriter pw = ing.getPixelWriter();
		for (int w = 0; w < wid; ++w) {
			for (int h = 0; h < hei; ++h)
				if ( pr.getColor(w, h).getOpacity() > .4 ) {
					pw.setArgb(w, h, pr.getArgb(w, h));
				}
		}
		
		this.decorated = ing;
		this.new_price = dec.getPrice() + price;
	}
	
	@Override
	public Image getImage() {
		return decorated;
	}
	
	@Override
	public double getPrice() {
		return new_price;
	}
}
