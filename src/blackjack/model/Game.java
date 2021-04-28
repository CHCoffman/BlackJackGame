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


    public static void main(String[] args) {
        Deck deck = new Deck();


        Hand player = new Hand();
        Hand dealer = new Hand();
        Hand player_tmp = null;
        ArrayList<Hand> handListPlayer = new ArrayList<Hand>();
        ArrayList<Hand> handListDealer = new ArrayList<Hand>();
        int playerScore, dealerScore;

        handListPlayer.add(player);
        handListDealer.add(dealer);


        deck.Display();
        System.out.println("\n\n");


        System.out.println("Dealer is shuffling deck . . .");
        deck.setDeck(deck.shuffle(deck.getDeck()));
        deck.Display();

        for (int i = 0; i < 2; i++) {
            Card temp = deck.deal();

            System.out.println(temp.getValue() + " of " + temp.getSuit());

            player.hand.add(temp);
            //player.display();
        }


        System.out.println("\n\n");
        for (int i = 0; i < 2; i++) {
            Card temp = deck.deal();

            System.out.println(temp.getValue() + " of " + temp.getSuit());

            dealer.hand.add(temp);
            //player.display();
        }


//		handListPlayer = Split(player);
//		
//		for(Hand h : handListPlayer) {
//			
//			for(Card c : h.getHand()) {
//			
//				System.out.println(c.getValue() + " of " + c.getSuit());
//			}
//			System.out.println("Hand complete\n");
//		}
//		
//		for(Hand h : handListDealer) {
//			
//			for(Card c : h.getHand()) {
//			
//				System.out.println(c.getValue() + " of " + c.getSuit());
//			}
//			System.out.println("Hand complete\n");
//		}

        System.out.println("\n\n");
        playerScore = player.sumValues(1);
        System.out.println("\n\n");
        dealerScore = dealer.sumValues(0);


        System.out.println(playerScore);
        System.out.println(dealerScore);


        if (playerScore > dealerScore) {
            System.out.println("You win!!!");
        } else if (playerScore < dealerScore) {
            System.out.println("You lose!!!");
        } else
            System.out.println("It's a tie!!!");
    }


    /**
     * Splits a player's hand into two hands
     *
     * @param hand the hand to be split in two. Should contain two card of equal value
     * @return an arraylist of hands, each containg one of the cards contained in the hand
     * passed in the argument
     */
    public static ArrayList<Hand> Split(Hand hand) {

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
