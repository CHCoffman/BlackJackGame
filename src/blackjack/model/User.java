package blackjack.model;

public class User extends Hands {
  private int wins;
  private int hands;
  private ArrayList<String> hand = new ArrayList<String>();
  
  public void hit(){
    /* More to be implemented */
    /* addCard(arg) is method of class Hand. Whenever called, it accepts an argument type ArrayList, and adds one card to this list*/
    addCard(hand);
  }
  
  public void stand(){
    /* More to be implemented */
    System.out.println("Can no longer draw more cards");
  }
  
  public void doubledown(){
    /* More to be implemented */
    addCard(hand);
    System.out.println("Can no longer draw more cards");
  }
  
  public void split(){
     /* More to be implemented */
    /* getValue() is a method of class Hand. It returns the string from "2" to "K" (Ex: "Ace").
    */
    if (hand.size() == 2 && (hand.get(0).getValue() == hand.get(1).getValue())){
      ArrayList<String> split = createHand();
      split.get(0) = hand.get(0);
      hand.remove(0);
      hands = hands + 1;
    }
  }
  
  public void fold(){
      /* More to be implemented */
     System.out.println("You surrender");
  }
  
  public ArrayList<String> createHand(){
     /* More to be implemented */
    ArrayList<String> hand = new ArrayList<String>;
    return hand;
}
  public void addWins(){
     /* More to be implemented */
    wins = wins + 1; 
  }
  
  public int getWins(){
     /* More to be implemented */
    return wins; 
  }
  
  public int getHands(){
     /* More to be implemented */
    return hands; 
  }
