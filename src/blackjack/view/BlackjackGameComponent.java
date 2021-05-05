package blackjack.view;

import blackjack.model.Card;
import blackjack.model.ModelEvent;
import blackjack.model.ModelListener;
import blackjack.view.ViewExceptions.BlackjackGUIException;

import javax.swing.*;
import java.awt.*;

/**
 * A GUI component for the entire blackjack game
 */
public class BlackjackGameComponent extends JPanel {
    private BlackjackHandComponent m_userHand;
    private BlackjackHandComponent m_dealerHand;
    private JPanel m_handPanel;
    private BlackjackControllerPanel m_controlPanel;

    /**
     * A GUI component for the entire blackjack game
     * @param listener A listener to register for gui updates
     */
    public BlackjackGameComponent(ModelListener listener) {
        m_userHand = new BlackjackHandComponent(5, new Dimension(100, 150));
        m_dealerHand = new BlackjackHandComponent(5, new Dimension(100, 150));
        m_handPanel = new JPanel();
        m_controlPanel = new BlackjackControllerPanel(listener);
        m_handPanel.setLayout(new GridLayout(2, 5));
        m_handPanel.add(m_dealerHand);
        m_handPanel.add(m_userHand);
        add(m_handPanel);
        add(m_controlPanel.GetPanel());
    }

    /**
     * Update the game's view with a new GameState
     * @param state The new state of the game
     * @throws BlackjackGUIException If either the player or dealer cards of the state are null.
     */
    public void UpdateViewComponent(GameState state) throws BlackjackGUIException {
        m_handPanel.setVisible(false);
        if(state.GetDealerCards() == null || state.GetPlayerCards() == null) {
            throw new BlackjackGUIException("Invalid game state");
        }
        if(state.GetPlayerCards().size() > 5) {
            System.out.println("Truncating player cards to 5");
        }
        m_handPanel.remove(m_dealerHand);
        m_dealerHand = new BlackjackHandComponent(5, new Dimension(100, 150));
        for(Card c : state.GetDealerCards()) {
            m_dealerHand.AddCard(c);
        }
        m_handPanel.add(m_dealerHand);
        m_handPanel.remove(m_userHand);
        m_userHand = new BlackjackHandComponent(5, new Dimension(100, 150));
        for(Card c : state.GetPlayerCards()) {
            m_userHand.AddCard(c);
        }
        m_handPanel.add(m_userHand);
        m_handPanel.setVisible(true);
        m_controlPanel.UpdatePlayerTotal(state.GetPlayerSum());
        m_controlPanel.UpdateDealerTotal(state.GetDealerSum());
        m_handPanel.revalidate();
        m_handPanel.repaint();
    }
}
