
public class Card {
	int value;
	String suit;
	
	Card(int vl, String st){
		this.value = vl;
		this.suit = st;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getSuit() {
		return this.suit;
	}
}
