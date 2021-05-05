package blackjack.view;

/**
 * An event representing a win or loss for the player in a game of blackjack
 */
public class WinLossEvent extends ViewEvent {
    public WinLossEvent(boolean playerWon) {
        m_type = playerWon ? ViewEventType.WIN : ViewEventType.LOSE;
    }
}
