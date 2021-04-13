package blackjack.view;

import blackjack.view.GuiUtils.GameWindow;
import blackjack.view.ViewExceptions.BlackjackDeckDataStoreException;

import javax.swing.*;
import java.awt.*;

public class View {
    public static void main(String[] args) {
        BlackjackDeckDataStore.Initialize();
        GameWindow w = new GameWindow("Blackjack", new Dimension(800, 600));
        BlackjackHandComponent p = new BlackjackHandComponent(5);
        try {
            BlackjackCardView HA = BlackjackDeckDataStore.GetCard(BlackjackCardData.CardSuite.HEARTS, 1, new Dimension(100, 150));
            BlackjackCardView C6 = BlackjackDeckDataStore.GetCard(BlackjackCardData.CardSuite.CLUBS, 6, new Dimension(100, 150));
            BlackjackCardView S6 = BlackjackDeckDataStore.GetCard(BlackjackCardData.CardSuite.SPADES, 6, new Dimension(100, 150));
            p.SetCard(new BlackjackCardComponent(HA), 0);
            p.SetCard(new BlackjackCardComponent(C6), 2);
            p.SetCard(new BlackjackCardComponent(S6), 1);
        }
        catch(BlackjackDeckDataStoreException e) {
            System.out.println(e);
        }
        w.add(p);
        w.pack();
        w.setVisible(true);
    }
}
