package blackjack.view;
import blackjack.model.Card;

import java.util.ArrayList;

public class GameState extends ViewEvent {
    private ArrayList<Card> m_playerCards;
    private ArrayList<Card> m_dealerCards;
    private int m_playerSum = 0;
    private int m_dealerSum = 0;

    /**
     * A representation of the current Blackjack Game's state
     * @param playerHand The player's cards
     * @param dealerHand The dealer's cards
     * @param playerTotal The current player score
     * @param dealerTotal The current dealer score
     */
    public GameState(ArrayList<Card> playerHand, ArrayList<Card> dealerHand, int playerTotal, int dealerTotal) {
        m_playerCards = playerHand;
        m_dealerCards = dealerHand;
        m_playerSum = playerTotal;
        m_dealerSum = dealerTotal;
        m_type = ViewEventType.UPDATE;
    }

    /**
     * Gets a list of the player's cards
     * @return The player's cards
     */
    public ArrayList<Card> GetPlayerCards() {
        return m_playerCards;
    }

    /**
     * Gets a list of the dealer's cards
     * @return The dealer's cards
     */
    public ArrayList<Card> GetDealerCards() {
        return m_dealerCards;
    }

    /**
     * Gets a the current hand total for the player's cards
     * @return The hand total for the player's cards
     */
    public int GetPlayerSum() { return m_playerSum; }

    /**
     * Gets the current hand total for the dealer's cards
     * @return The hand total for the dealer's cards
     */
    public int GetDealerSum() { return m_dealerSum; }
}
