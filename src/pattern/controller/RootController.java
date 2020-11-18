package pattern.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import pattern.adapter.AnimalVehicle;
import pattern.adapter.Car;
import pattern.adapter.TargetVehicle;

import java.util.ArrayList;

public class RootController {
	@FXML
	public TextArea animalLog;
	@FXML
	public TextArea carLog;
	
	ArrayList<TargetVehicle> vehicles;
	
	public void initialize() {
		vehicles = new ArrayList<>();
		vehicles.add(new Car(carLog));
		vehicles.add(new AnimalVehicle(animalLog));
	}
	
	public void startup(ActionEvent actionEvent) {
		vehicles.forEach(TargetVehicle::startup);
	}
	
	public void shutdown(ActionEvent actionEvent) {
		vehicles.forEach(TargetVehicle::shutdown);
	}
	
	public void accelerate(ActionEvent actionEvent) {
		vehicles.forEach(e -> e.accelerate(10));
	}
	
	public void decelerate(ActionEvent actionEvent) {
		vehicles.forEach(e -> e.decelerate(10));
	}
}
