package blackjack.model;

import java.util.ArrayList;
import java.util.Arrays;
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
	 * 
	 * @param deck the deck that is to be shuffled
	 */
	public ArrayList<Card> shuffle(ArrayList<Card> deck) {
		// SHUFFLE DECK
		Card[] cardArray = new Card[deck.size()];
		Card tmp = null;
		int index;
		int i, j;
		
		Random rand = new Random();
		
		for(i = 0; i < cardArray.length; i++) {
			j = i + rand.nextInt(50 - i);
			
			tmp = cardArray[i];
			cardArray[j] = cardArray[i];
			cardArray[i] = tmp;
			
		}
		
		
			
		
		
		ArrayList<Card> tempList = new ArrayList<Card>(Arrays.asList(cardArray));
		
		for(Card c : deck) {
			System.out.println(c.getValue() + " of " + c.getSuit());
		}
		return tempList;
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
