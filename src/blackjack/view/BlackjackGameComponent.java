package blackjack.view;

import blackjack.model.Card;
import blackjack.view.ViewExceptions.BlackjackGUIException;

import javax.swing.*;
import java.awt.*;

public class BlackjackGameComponent extends JPanel {
    private BlackjackHandComponent m_userHand;
    private BlackjackHandComponent m_dealerHand;
    private JPanel handPanel;
    private BlackjackControllerPanel controlPanel;

    public BlackjackGameComponent() {
        m_userHand = new BlackjackHandComponent(5, new Dimension(100, 150));
        m_dealerHand = new BlackjackHandComponent(5, new Dimension(100, 150));
        handPanel = new JPanel();
        controlPanel = new BlackjackControllerPanel();
        controlPanel.setLayout(new GridLayout(4, 1));
        handPanel.setLayout(new GridLayout(2, 5));
        handPanel.add(m_dealerHand);
        handPanel.add(m_userHand);
        add(handPanel);
        add(controlPanel);
    }

    public void UpdateViewComponent(GameState state) throws BlackjackGUIException {
        if(state.GetDealerCards() == null || state.GetPlayerCards() == null) {
            throw new BlackjackGUIException("Invalid game state");
        }
        if(state.GetPlayerCards().size() > 5) {
            System.out.println("Truncating player cards to 5");
        }
        handPanel.remove(m_dealerHand);
        m_dealerHand = new BlackjackHandComponent(5, new Dimension(100, 150));
        for(Card c : state.GetDealerCards()) {
            m_dealerHand.AddCard(c);
        }
        handPanel.add(m_dealerHand);
        handPanel.remove(m_userHand);
        m_userHand = new BlackjackHandComponent(5, new Dimension(100, 150));
        for(Card c : state.GetPlayerCards()) {
            m_userHand.AddCard(c);
        }
        handPanel.add(m_userHand);
        controlPanel.UpdatePlayerTotal(state.GetPlayerSum());
        controlPanel.UpdateDealerTotal(state.GetDealerSum());
    }
}
