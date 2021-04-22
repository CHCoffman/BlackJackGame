package blackjack.view;
import blackjack.model.Card;
public class GameState {
    private int[] m_playerCards;
    private int[] m_dealerCards;
    public GameState(int[] playerHand, int[] dealerHand) {
        m_playerCards = playerHand;
        m_dealerCards = dealerHand;
    }
    public int[] GetPlayerCards() {
        return m_playerCards;
    }
    public int[] GetDealerCards() {
        return m_dealerCards;
    }
}
