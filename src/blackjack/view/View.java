package blackjack.view;

import blackjack.model.Card;
import blackjack.view.GuiUtils.GameWindow;
import blackjack.view.ViewExceptions.BlackjackDeckDataStoreException;

import javax.swing.*;
import java.awt.*;

import blackjack.view.GuiUtils.GameWindow;
import blackjack.view.ViewExceptions.BlackjackGUIException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class View {
    public static void main(String[] args) {
        BlackjackDeckDataStore.Initialize();
        GameWindow w = new GameWindow("Blackjack", new Dimension(800, 600));
        BlackjackGameComponent gameComponent = new BlackjackGameComponent();
        w.add(gameComponent);
        ArrayList<Card> userHand = new ArrayList<Card>(Arrays.asList(
                new Card("3", "Clubs"),
                new Card("4", "Clubs"),
                new Card("5", "Clubs"),
                new Card("A", "Clubs")));
        ArrayList<Card> dealerHand = new ArrayList<Card>(Arrays.asList(
                new Card("3", "Clubs"),
                new Card("4", "Spades"),
                new Card("5", "Diamonds"),
                new Card("6", "Hearts")));
        GameState state = new GameState(userHand, dealerHand, 18, 18);
        try {
            gameComponent.UpdateViewComponent(state);
        }
        catch(BlackjackGUIException e) {
            System.out.println("Unknown GUI error");
        }

        w.pack();
        w.setVisible(true);
    }
}
