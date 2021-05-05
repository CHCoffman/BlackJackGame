package blackjack.view;

public class WinLossEvent extends ViewEvent {
    public WinLossEvent(boolean playerWon) {
        m_type = playerWon ? ViewEventType.WIN : ViewEventType.LOSE;
    }
}
