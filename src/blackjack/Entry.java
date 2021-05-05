package blackjack;

import blackjack.model.Card;
import blackjack.model.Game;
import blackjack.model.ModelEvent;
import blackjack.view.GameState;
import blackjack.view.View;
import blackjack.view.ViewExceptions.BlackjackGUIException;
import blackjack.view.WinLossEvent;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The entry point for the blackjack game
 */
public class Entry {
    public static void main(String[] args) {
        Game gameImpl = new Game();
        View gameView = new View(gameImpl);
        gameImpl.AddView(gameView);
        try {
            gameView.ReceiveEvent(gameImpl.GetState());
            Thread.sleep(3000);
            ArrayList<Card> playerCards = new ArrayList<>(Arrays.asList(new Card("5", "Clubs")));
            ArrayList<Card> dealerCards = new ArrayList<>(Arrays.asList(new Card("8", "Diamonds")));
            gameView.ReceiveEvent(new GameState(playerCards, dealerCards, 5, 8));
        }
        catch(BlackjackGUIException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
