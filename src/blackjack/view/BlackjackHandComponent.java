package blackjack.view;

import blackjack.model.Card;
import blackjack.view.ViewExceptions.BlackjackDeckDataStoreException;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BlackjackHandComponent extends JPanel {
    private BlackjackCardComponent[] m_cards;
    private int m_curCardIndex = 0;

    /**
     * A BlackjackHandComponent is a collection of BlackjackCardComponents, used to display a particular hand
     * @param maxHandSize The maximum number of cards in a hand
     * @param cardSize The on screen dimensions of each of the hands cards
     */
    public BlackjackHandComponent(int maxHandSize, Dimension cardSize) {
        m_cards = new BlackjackCardComponent[maxHandSize];
        setLayout(new GridLayout(1, maxHandSize));
        setMinimumSize(cardSize);
        setMaximumSize(cardSize);
        setPreferredSize(cardSize);
    }

    /**
     * Adds a new card to the hand
     * @param c The card to add
     * @return If the card was successfully added
     */
    public boolean AddCard(Card c) {
        if(m_curCardIndex == m_cards.length) {
            return false;
        }
        BlackjackCardView v = BlackjackDeckDataStore.GetCard(c, new Dimension(100, 150));
        BlackjackCardComponent cardComponent = new BlackjackCardComponent(v);
        int thisCardIndex = m_curCardIndex;
        m_cards[m_curCardIndex] = cardComponent;
        m_cards[m_curCardIndex].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        add(cardComponent);
        m_curCardIndex++;
        return true;
    }

    /**
     * Sets a specific card in the hand
     * @param v A new card to set
     * @param index The index of the card component
     */
    public void SetCard(BlackjackCardComponent v, int index) {
        if(m_cards[index] != null) {
            remove(m_cards[index]);
        }
        m_cards[index] = v;
        m_cards[index].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        add(m_cards[index]);
    }
}
