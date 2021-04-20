package blackjack.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Deck {
	private static
		ArrayList<Card> deck = new ArrayList<Card>();
	
	Deck() {
		String suit[] = {"Spades", "Clubs", "Diamonds", "Spades"};
		String values[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		
		
		for(String s : suit) {
			for(String v : values) {
				deck.add(new Card(v, s));
			}
		}
		// INITIALIZATION
	}
	
//	public static void Shuffle(ArrayList<Card> deck) {
//		// SHUFFLE DECK
//		Card[] array = new Card[deck.size()];
//		List<Integer> positions = new ;
//		int[] positions = new int[deck.size()];
//		int index;
//		int i = 0;
//		Random rand = null;
//		
//		for(Card c : deck) {
//			index = rand.nextInt((deck.size() - 0) + 1) + 0;
//			array[index] = c;
//			positions[i] = index;
//			i++;
//		}
//		
//		
//		
//		List<Card> tempList = new ArrayList<Card>(Arrays.asList(array));
//	}
//	
	
	public static void Deal() {
		
	}
	
	public static void Display() {
		for(Card c : deck) {
			System.out.println(c.getValue() + " of " + c.getSuit());
		}
	}
}