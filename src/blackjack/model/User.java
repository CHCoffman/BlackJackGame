package blackjack.model;

import java.util.ArrayList;
import java.util.*;

public class User extends Hand {
  private int wins = 0;
  private int numHands = 0;
  private ArrayList<Card> hand = new ArrayList<Card>(); // hand variable is array of Card objects
  private ArrayList<ArrayList<Card>> handsList = new ArrayList<ArrayList<Card>>(); // list of hands the user has
  private ArrayList<Integer> numCards = new ArrayList<Integer>(); // numCards stores total cards for each hand

  //Constructor: deal first hand to user
  public User(){
    this.addCard(hand); // 1st card
    this.addCard(hand); // 2nd card
    this.handsList.add(hand); // increase number of hands
    this.numCards.set(0, 2); // total cards for this hand is 2 initially
    this.numHands++;
  }
  // hit function asks player which hand they want to hit, so handNumber argument is passed
  public void hit(int handNumber){
    /* addCard(arg) is method of class Hand. Whenever called, it accepts an argument type Card, and adds one card to hand (list of Card objects)*/
    if(this.numHands == 0){ // if player just starts and no hands yet
      this.addCard(hand);
      this.handsList.add(hand); // increase number of hands
      this.numCards.set(0, 1);
      this.numHands++;
    }
    else{
      this.addCard(handsList.get(handNumber)); // add one card to the hand that player chooses to hit
      int totalForCurHand = this.numCards.get(handNumber);
      totalForCurHand++;
      this.numCards.set(handNumber, totalForCurHand); //increment total cards in current hand
    }

  }

  public void stand(){
    System.out.println("\nYou stand. Can no longer draw more cards\n");
  }

  // Each hand receives only 1 opportunity to double down – directly after the initial two cards have been dealt.
  // After receive the third card, you can no longer draw more card to that hand.
  // Pass handNumber argument to indicate which hand the player wants to double down.
  public void doubleDown(int handNumber){
    // Check if hand has 2 cards
    ArrayList<Card> wantToDB = handsList.get(handNumber);
    if(wantToDB.size() == 2){
      hit(handNumber); // Receive 1 more card for that hand
      System.out.println("\nDoubled down. Can no longer draw more cards\n");
    }
    else{
      System.out.println("\nYour hand has more than 2 cards. Cannot double down\n");
    }

  }

  // Pass handNumber argument to indicate which hand the player wants to split.
  public void split(int handNumber){
    /* getValue() is a method of class Hand. It returns one integer, representing card value ranging from "A" to "K" (Ex: returns 1 meaning "Ace").
     */
    ArrayList<Card> wantToSplit = this.handsList.get(handNumber); 
    // If the hand the player wants to split has exaclty 2 cards, and they have the same value (ex: "2" and "2"), then the hand can split
    if (wantToSplit.size() == 2 && (wantToSplit.get(0).getValue() == wantToSplit.get(1).getValue())){
      ArrayList<Card> split = new ArrayList<Card>();
      split.add(0, wantToSplit.get(0)); // assign the first card of current hand to the split hand
      wantToSplit.remove(0);  // remove the first card of current hand
      int totalForCurHand = this.numCards.get(handNumber); 
      totalForCurHand--;
      this.numCards.set(handNumber, totalForCurHand); //decrement total cards in current hand
      this.numHands++; // increment total of hands user has. split hand is the latest one
      this.numCards.add(1); // add 1 to total cards in split hand
    }
  }

  public void fold(){
    System.out.println("\nYou surrender\n");
  }

  // handNumber: indicate which hand the player wants to get sum from
  public int getHandSum(int handNumber){
    int handSum = 0;
    int cardValue;
    int numAces = 0;

    ArrayList<Card> wantSum = this.handsList.get(handNumber);
    cardValue = wantSum.getValue();
    if(cardValue == 1){ //Ace
      numAces++;
      handSum += 11;
    }
    else if (cardValue > 10){ //face card
      handSum += 10;
    }
    else{
      handSum += cardValue;
    }
   
    // decide whether ace is 1 or 11
    // while handSum > 21 and numAces > 0, change ace card from 11 to 1, decrement numAces
    while (handSum > 21 && numAces > 0){
      handSum -= 10;
      numAces--;
    }

    return handSum;
  }
  
  // Check for win of a hand, and incrementing the win if condition holds.
  // Pass the hand you want to determine the win, and pass sum scores of dealer
  public void determineWin(int handNumber, int dealerSum){
    int handSum = getHandSum(handNumber); // get sum of this hand

    if(handSum == 21 && dealerSum != 21) {
      System.out.println("\nYou got blackjack for this hand!\n");
      this.wins++;
    }
    else if (handSum > dealerSum && handSum < 21) {
      System.out.println("\nThis hand beats the dealer.\n");
      this.wins++;
    }
    
     else if (handSum < dealerSum && dealerSum < 21){
      System.out.println("\nThe dealer beats this hand.\n");
    }

    else if (handSum == dealerSum && handSum < 21 && dealerSum < 21){
      System.out.println("\nThis hand has a tie with the dealer.\n");
    }
 
    else if (dealerSum > 21 && handSum < 21){
      System.out.println("\nThe dealer busts.\n");
      this.wins++;
    }
    
    else { // handSum > 21
      System.out.println("\nThis hand busts.\n");
    }

  }

  public void addWins(){
    this.wins++;
  }

  public int getWins(){
    return this.wins;
  }

  public int getHands(){
    return this.numHands;
  }
}
