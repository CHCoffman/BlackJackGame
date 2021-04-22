
public class Card {
	String value;
	String suit;
	boolean aceHigh;
	
	Card(String vl, String st){
		this.value = vl;
		this.suit = st;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public String getSuit() {
		return this.suit;
	}
}
