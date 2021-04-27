package blackjack.model;

public class Card {
	String value;
	String suit;
	boolean aceHigh;
	
	public Card(String vl, String st){
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