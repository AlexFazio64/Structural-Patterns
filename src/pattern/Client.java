package pattern;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pattern.composite.ComponentInterface;
import pattern.composite.Composite.Case;
import pattern.composite.Composite.CompositeComponent;
import pattern.composite.Composite.MotherBoard;
import pattern.composite.GraphicalComponent;
import pattern.composite.Leaf.CPU;
import pattern.composite.Leaf.FAN;
import pattern.composite.Leaf.GPU;
import pattern.composite.Leaf.RAM;
import pattern.controller.CaseInteriorController;
import pattern.controller.ComponentInfoController;
import pattern.controller.MoboViewController;
import pattern.controller.RootController;

import java.io.IOException;

public class Client extends Application {
	public static Stage primary;
	public static Scene root_level;
	public static Scene case_level;
	public static Scene mobo_level;
	public static Scene component_info;
	public static ComponentInfoController info_controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primary = primaryStage;
		primaryStage.setScene(root_level);
		primaryStage.setTitle("Desktop Explorer");
		primaryStage.setResizable(false);
		primaryStage.setWidth(600);
		primaryStage.setHeight(400);
		primaryStage.show();
	}
	
	public static void main(String[] args) throws IOException {
		CompositeComponent chassis = new Case("Zephyrus S", "Asus", 175, fetch("case.png"), 2);
		CompositeComponent mobo = new MotherBoard("custom", "Asus", 150.0, fetch("mobo.png"), 1, 2, 1, 2);
		ComponentInterface cpu = new CPU("i7 9750h", "Intel", 200, fetch("cpu.png"));
		ComponentInterface gpu = new GPU("RTX 2060", "NVIDIA", 350, fetch("gpu.png"));
		ComponentInterface ram = new RAM("16GB", "sk-hynix", 130, fetch("ram.png"));
		ComponentInterface c_fan = new FAN("Zephyrus S", "Asus", 40, fetch("fan.png"));
		ComponentInterface m_fan = new FAN("Zephyrus S", "Asus", 40, fetch("fan.png"));
		
		chassis.addComponent(mobo);
		chassis.addComponent(c_fan);
		mobo.addComponent(cpu);
		mobo.addComponent(gpu);
		mobo.addComponent(ram);
		mobo.addComponent(m_fan);
		
		FXMLLoader l = new FXMLLoader(Client.class.getResource("view/root.fxml"));
		FXMLLoader l1 = new FXMLLoader(Client.class.getResource("view/case_interior" + ".fxml"));
		FXMLLoader l2 = new FXMLLoader(Client.class.getResource("view/mobo_view.fxml"));
		FXMLLoader l3 = new FXMLLoader(Client.class.getResource("view/component_info.fxml"));
		
		root_level = new Scene(l.load());
		case_level = new Scene(l1.load());
		mobo_level = new Scene(l2.load());
		component_info = new Scene(l3.load());
		
		GraphicalComponent g_chassis = new GraphicalComponent(chassis, case_level, root_level);
		GraphicalComponent g_fan = new GraphicalComponent(c_fan, null, root_level);
		GraphicalComponent g_mobo = new GraphicalComponent(mobo, mobo_level, root_level);
		GraphicalComponent g_cpu = new GraphicalComponent(cpu, null, case_level);
		GraphicalComponent g_gpu = new GraphicalComponent(gpu, null, case_level);
		GraphicalComponent g_ram = new GraphicalComponent(ram, null, case_level);
		GraphicalComponent g_fan2 = new GraphicalComponent(m_fan, null, case_level);
		
		RootController rc = l.getController();
		rc.init(g_chassis);
		CaseInteriorController cc = l1.getController();
		cc.init(g_mobo, g_fan);
		MoboViewController mc = l2.getController();
		mc.init(g_cpu, g_gpu, g_ram, g_fan2);
		info_controller = l3.getController();
		
		launch(args);
	}
	
	public static String fetch(String file) {
		return Client.class.getResource("resources/" + file).toString();
	}
}
