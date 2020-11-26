package pattern.facade;

import javafx.scene.layout.BorderPane;
import pattern.Client;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Facade {
	private static final FileExtensionChecker audio = new FileExtensionChecker("mp3", "wav");
	private static final FileExtensionChecker graphic = new FileExtensionChecker("jpg", "jpeg", "png", "bmp");
	
	public static List<BorderPane> exploreDirectory(String directory) {
		ArrayList<BorderPane> files = new ArrayList<>();
		
		File dir = new File(directory);
		
		if ( dir.isDirectory() ) {
			String[] file_names = dir.list();
			
			if ( file_names != null ) {
				for (String s: file_names) {
					StandaloneFile f;
					if ( audio.check(s) ) {
						f = new AudioFile(Client.res(s));
					} else if ( graphic.check(s) ) {
						f = new GraphicFile(Client.res(s));
					} else {
						continue;
					}
					files.add(FilePacker.wrapFile(f));
				}
			} else {
				throw new RuntimeException("directory is empty");
			}
		} else {
			throw new RuntimeException("not a directory");
		}
		
		return files;
	}
}
