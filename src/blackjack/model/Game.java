package blackjack.model;

import java.util.ArrayList;

public class Game {
    public Game() {
        // Initialize game state
        Player = 0;
        Dealer = 0;
    }
    public void OnEvent() { // Event e
        // Update game state
        Player++;
        Dealer++;
    }
    // Make these Users
    public int Player;
    public int Dealer;
    
    
    public static ArrayList<Hand> Split(Hand hand){
		
		ArrayList<Hand> tmp = new ArrayList<Hand>();
		Hand tmpHand = null;
		
		
		tmpHand = new Hand();
		tmpHand.getHand().add(hand.getHand().get(1));
		hand.getHand().remove(1);
		
		
		tmp.add(hand);
		tmp.add(tmpHand);
		
		return tmp;
		
	}
    
}
