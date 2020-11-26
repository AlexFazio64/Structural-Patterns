package pattern.facade;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioFile extends StandaloneFile {
	Media file;
	MediaPlayer mp;
	
	public AudioFile(String path) {
		super("audio", path);
		file = new Media(path);
		mp = new MediaPlayer(file);
	}
	
	@Override
	public void open() {
		if ( mp.getStatus() != MediaPlayer.Status.PLAYING ) {
			mp.play();
		} else {
			mp.stop();
		}
	}
}
