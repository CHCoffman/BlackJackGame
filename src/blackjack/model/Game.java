package blackjack.model;

import blackjack.view.GameState;
import blackjack.view.ViewEventDispatcher;
import blackjack.view.ViewEventListener;
import blackjack.view.ViewExceptions.BlackjackGUIException;
import blackjack.view.WinLossEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Game implements ModelListener{
    private User player;
    private User dealer;
    private ViewEventDispatcher dispatcher;

    /**
     * A representation of a blackjack game
     */
    public Game() {
        dispatcher = new ViewEventDispatcher();
        // Deal cards to player and dealer
    }

    /**
     * Adds a ViewEventListener to the game
     * @param listener The listener to add
     */
    public void AddView(ViewEventListener listener) {
        dispatcher.AddListener(listener);
    }

    /**
     * Dispatches an event to the Game's views
     * @param me The event to dispatch
     */
    @Override
    public void modelChanged(ModelEvent me) {
        System.out.println(me.GetType().toString());
        try {
            // If the player has won: dispatcher.DispatchEvent(new WinLossEvent(true));
            // If the dealer has won: dispatcher.DispatchEvent(new WinLossEvent(false));
            // else
            dispatcher.DispatchEvent(GetState());
        }
        catch(BlackjackGUIException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Gets the current state of the game
     * @return The current game state
     */
    public GameState GetState() {
        ArrayList<Card> playerCards = new ArrayList<>(Arrays.asList(new Card("3", "Clubs")));
        ArrayList<Card> dealerCards = new ArrayList<>(Arrays.asList(new Card("4", "Diamonds")));
        return new GameState(playerCards, dealerCards, 3, 4);
    }
}
