package blackjack.model;

<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.util.*;
>>>>>>> CCTest

/* More to be implemented for class User  */
public class User extends Hand {
  private int wins;
  private int hands;
  private ArrayList<Card> hand = new ArrayList<Card>();
  
  public void hit(){
    /* addCard(arg) is method of class Hand. Whenever called, it accepts an argument type Card, and adds one card to this list*/
    addCard(hand);
  }
  
  public void stand(){
    System.out.println("Can no longer draw more cards");
  }
  
  public void doubledown(){
    addCard(hand);
    System.out.println("Can no longer draw more cards");
  }
  
  public void split(){
    /* getValue() is a method of class Hand. It returns one string, representing card value ranging from "2" to "K" (Ex: returns "Ace").
    */
    if (hand.size() == 2 && (hand.get(0).getValue() == hand.get(1).getValue())){
      ArrayList<Card> split = createHand();
      split.get(0) = hand.get(0);
      hand.remove(0);
      hands = hands + 1;
    }
  }
  
  public void fold(){
     System.out.println("You surrender");
  }
  
  public ArrayList<Card> createHand(){
    ArrayList<Card> hand = new ArrayList<Card>();
    return hand;
}
  public void addWins(){
    wins = wins + 1; 
  }
  
  public int getWins(){
    return wins; 
  }
  
  public int getHands(){
    return hands; 
  }
