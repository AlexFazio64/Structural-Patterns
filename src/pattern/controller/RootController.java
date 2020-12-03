package pattern.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import pattern.Client;
import pattern.flyweight.CharacterFlyweightFactory;
import pattern.flyweight.CharacterView;

public class RootController {
	public Label ramLbl;
	public Label charsLbl;
	public Button clearBtn;
	public TextField raw_inputTf;
	public TextField flyTf;
	public Slider multiplierSld;
	public FlowPane flowPn;
	
	public void reset(ActionEvent actionEvent) {
		flowPn.getChildren().clear();
		raw_inputTf.setText("");
		flyTf.setText("");
		multiplierSld.setValue(0);
		ramLbl.setText("0");
		charsLbl.setText("0 characters");
	}
	
	public void raw_loadBtn(ActionEvent actionEvent) {
		flowPn.getChildren().clear();
		flyTf.setText(raw_inputTf.getText());
		char[] sanitized = raw_inputTf.getText().toLowerCase().toCharArray();
		
		int loops = (int) multiplierSld.getValue();
		int i = 0;
		
		do {
			for (char c: sanitized)
				if ( c >= 'a' && c <= 'z' ) {
					flowPn.getChildren().add(new CharacterView(new Image(Client.getRes(c + ".png"), 35, 35, true, true)));
				}
		} while (i++ < loops);
		
		stats();
	}
	
	public void fly_loadBtn(ActionEvent actionEvent) {
		flowPn.getChildren().clear();
		raw_inputTf.setText(flyTf.getText());
		char[] sanitized = flyTf.getText().toLowerCase().toCharArray();
		
		int loops = (int) multiplierSld.getValue();
		int i = 0;
		
		do {
			for (char c: sanitized)
				if ( c >= 'a' && c <= 'z' ) {
					flowPn.getChildren().add(CharacterFlyweightFactory.requestCharacter(c));
				}
		} while (i++ < loops);
		
		stats();
	}
	
	private void stats() {
		Runtime r = Runtime.getRuntime();
		long mem = r.maxMemory() - r.freeMemory();
		mem /= 1024;
		mem /= 1024;
		ramLbl.setText(mem + "MB");
		charsLbl.setText(flowPn.getChildren().size() + " characters");
	}
	
}
