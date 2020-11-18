package pattern.adapter;

public class AdapteeAnimal {
	protected String type;
	protected String call;
	protected boolean domestic;
	
	public AdapteeAnimal(String t, String v, boolean d) {
		this.type = t;
		this.domestic = d;
		this.call = d ? v.toLowerCase() : v.toUpperCase();
	}
	
	public String pet() {
		if ( domestic ) {
			return ( call + "<3" );
		} else {
			domestic = Math.random() >= 0.8;
			return ( "\"?" + call + "?/" );
		}
	}
	
	public String shout() {
		return ( call + "!\t:/" );
	}
}
