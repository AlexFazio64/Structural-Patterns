package pattern.facade;

public class FileExtensionChecker {
	private final String[] exts;
	
	public FileExtensionChecker(String... list) {
		exts = list;
	}
	
	public boolean check(String name) {
		String[] tok = name.split("\\.");
		for (String ext: exts) {
			if ( tok[tok.length - 1].equalsIgnoreCase(ext) ) {
				return true;
			}
		}
		return false;
	}
}
