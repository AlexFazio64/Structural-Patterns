package pattern.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import pattern.Client;
import pattern.decorator.Component;
import pattern.decorator.ConcretePizza;
import pattern.decorator.Decorator;

public class RootController {
	public BorderPane picPane;
	public Label priceLbl;
	public Button sauceBtn;
	public Button mozzarellaBtn;
	public Button salamiBtn;
	public Button mediaBtn;
	public Button resetBtn;
	public ImageView pic;
	private MediaPlayer mp;
	Component pizza;
	Image base;
	Image sauce;
	Image mozzarella;
	Image salami;
	
	public void initialize() {
		mp = new MediaPlayer(new Media(Client.getRes("resources/pizza-time.mp3")));
		mp.setVolume(.5);
		mp.setCycleCount(Integer.MAX_VALUE);
		mp.play();
		
		base = new Image(Client.getRes("resources/base.png"), 256, 256, true, true);
		sauce = new Image(Client.getRes("resources/sauce.png"), 256, 256, true, true);
		mozzarella = new Image(Client.getRes("resources/mozzarella.png"), 256, 256, true, true);
		salami = new Image(Client.getRes("resources/salami.png"), 256, 256, true, true);
		
		pizza = new ConcretePizza(base, 3.5);
		pic = new ImageView(pizza.getImage());
		picPane.setCenter(pic);
		priceLbl.setText(String.valueOf(pizza.getPrice()));
	}
	
	public void reset(ActionEvent actionEvent) {
		mp.stop();
		initialize();
	}
	
	public void addSauce(ActionEvent actionEvent) {
		pizza = new Decorator(pizza, sauce, 1.25);
		pic.setImage(pizza.getImage());
		priceLbl.setText(String.valueOf(pizza.getPrice()));
	}
	
	public void addCheese(ActionEvent actionEvent) {
		pizza = new Decorator(pizza, mozzarella, 2);
		pic.setImage(pizza.getImage());
		priceLbl.setText(String.valueOf(pizza.getPrice()));
	}
	
	public void addSalami(ActionEvent actionEvent) {
		pizza = new Decorator(pizza, salami, 1.5);
		pic.setImage(pizza.getImage());
		priceLbl.setText(String.valueOf(pizza.getPrice()));
	}
	
	public void pizzeria(ActionEvent actionEvent) {
		if ( mp.getStatus() == MediaPlayer.Status.PLAYING ) {
			mp.pause();
		} else {
			mp.play();
		}
	}
}
