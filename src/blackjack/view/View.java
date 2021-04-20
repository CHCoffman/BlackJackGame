package blackjack.view;

import blackjack.view.GuiUtils.GameWindow;
import blackjack.view.ViewExceptions.BlackjackDeckDataStoreException;

import javax.swing.*;
import java.awt.*;

public class View {
    public static void main(String[] args) {
        BlackjackDeckDataStore.Initialize();
        GameWindow w = new GameWindow("Blackjack", new Dimension(800, 600));
        BlackjackHandComponent hand = new BlackjackHandComponent(5, new Dimension(100, 150));
        for(int i = 9; i < 14; i ++) {
            hand.AddCard(i, BlackjackCardData.CardSuite.HEARTS);
        }
        w.add(hand);
        w.pack();
        w.setVisible(true);
    }
}
