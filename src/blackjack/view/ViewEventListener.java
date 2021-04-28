package blackjack.view;

import blackjack.view.ViewExceptions.BlackjackGUIException;

public interface ViewEventListener {
    void ReceiveEvent(GameState state) throws BlackjackGUIException;
}
