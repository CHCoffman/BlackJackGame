package blackjack.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@SuppressWarnings("unused")
public class Deck {
	private static
		ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck() {
		String suit[] = {"Spades", "Clubs", "Diamonds", "Hearts"};
		String values[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		
		
		for(String s : suit) {
			for(String v : values) {
				deck.add(new Card(v, s));
			}
		}
		// INITIALIZATION
	}

	/**
	 * Shuffles a given deck and returns a new deck in a random order
	 * @param deck the deck that is to be shuffled
	 */
	public ArrayList<Card> shuffle(ArrayList<Card> deck) {
		List<Card> cardList = new ArrayList<Card>();   //Creates a List of type Card (because Collections.shuffle() does not work for ArrayLists)
		ArrayList<Card> temp = new ArrayList<Card>();
		
		for(Card c : deck) {   // Load contents of deck ArrayList into List
			cardList.add(c);
		}
		Collections.shuffle(cardList);
		
		for(Card c : cardList) {  // Load contents of new List into our new ArrayList
			temp.add(c);
		}
		
		return temp;
	}
	
	/**
	 * Removes and returns the first card in deck to be sent to a hand
	 * @return the card to be dealt
	 */
	public Card deal() {
		Card dealtCard = deck.get(0);
		deck.remove(0);
		return dealtCard;
	}
	
	/**
	 * Simply displays suits and values of all cards in deck
	 */
	public static void Display() {
		for(Card c : deck) {
			System.out.println(c.getValue() + " of " + c.getSuit());
		}
	}
	
	
	public ArrayList<Card> getDeck(){
		return Deck.deck;
	}
	
	public void setDeck(ArrayList<Card> deckArg) {
		deck = deckArg;
	}
}
