package pattern.flyweight;

import javafx.scene.image.Image;
import pattern.Client;

import java.util.HashMap;

public class CharacterFlyweightFactory {
	//intrinsic state
	private static HashMap<Character, Image> cache = null;
	
	public static CharacterView requestCharacter(char chr) {
		if ( cache == null ) {
			cache = new HashMap<>();
		}
		
		if ( !cache.containsKey(chr) ) {
			cache.put(chr, new Image(Client.getRes(chr + ".png"), 35, 35, true, true));
		}
		
		return new CharacterView(cache.get(chr));
	}
}
