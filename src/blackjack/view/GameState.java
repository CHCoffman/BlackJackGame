package blackjack.view;
import blackjack.model.Card;

import java.util.ArrayList;

public class GameState {
    private ArrayList<Card> m_playerCards;
    private ArrayList<Card> m_dealerCards;
    private int m_playerSum = 0;
    private int m_dealerSum = 0;
    public GameState(ArrayList<Card> playerHand, ArrayList<Card> dealerHand, int playerTotal, int dealerTotal) {
        m_playerCards = playerHand;
        m_dealerCards = dealerHand;
        m_playerSum = playerTotal;
        m_dealerSum = dealerTotal;
    }
    public ArrayList<Card> GetPlayerCards() {
        return m_playerCards;
    }
    public ArrayList<Card> GetDealerCards() {
        return m_dealerCards;
    }
    public int GetPlayerSum() { return m_playerSum; }
    public int GetDealerSum() { return m_dealerSum; }
}
