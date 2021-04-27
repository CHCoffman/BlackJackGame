package blackjack.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Hand {
	ArrayList<Card> hand = new ArrayList<Card>();
	String[] royals = {"J", "Q", "K"};      
	Scanner sc = new Scanner(System.in);
	List<String> rList = Arrays.asList(royals);
	int sum;
	int numAces = 0;
	String choice;
	
	/**
	 * @return the local hand function
	 */
	public ArrayList<Card> getHand(){
		return hand;
	}
	
	/**
	 * Transfers a new card from the main deck to the player's hand.
	 * @param deck the main deck that cards will be taken from
	 */
	public void hit(Deck deck) {
		Card temp = deck.deal();
		hand.add(temp);
		if(temp.getValue().equals("A"))
			numAces++;
	}
	
	/**
	 * Used to calculate the total of a player's hand
	 * @return the sum of all card values in hand
	 */
	public int sumValues() {
		sum = 0;
		for(Card c : hand) {
			if(rList.contains(c.getValue()))
				sum += 10;
			else if(c.getValue().equals("A")) {
				System.out.println("Ace high or low? (enter h or l)");
				choice = sc.nextLine();
				if(choice.equals("h"))
					sum += 11;
				else
					sum += 1;
			}
			else
				sum += Integer.valueOf(c.getValue());			
		}
		return sum;
	}
	
	/**
	 * Simply displays suits and values of all cards in hand
	 */
	public void display() {
		for(Card c : hand) {
			System.out.println(c.getValue() + " of " + c.getSuit());
		}
	}
}
