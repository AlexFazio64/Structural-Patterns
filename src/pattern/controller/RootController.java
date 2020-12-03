package pattern.controller;

import javafx.scene.layout.FlowPane;
import pattern.proxy.Facade;

import java.io.File;

public class RootController {
	
	public FlowPane content_pane;
	
	public void initialize() {
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "pattern" + File.separator + "resources";
		boolean use_proxy = true;
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 200; i++)
			content_pane.getChildren().addAll(Facade.exploreDirectory(path, use_proxy));
		System.out.println(System.currentTimeMillis() - start + "ms elapsed");
	}
}