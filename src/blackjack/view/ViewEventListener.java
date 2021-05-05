package blackjack.view;

import blackjack.view.ViewExceptions.BlackjackGUIException;

/**
 * An interface for classes that want to receive ViewEvents
 */
public interface ViewEventListener {
    /**
     * Receive and/or process a view event
     * @param state The GameState to act as the view event
     * @throws BlackjackGUIException If something goes wrong
     */
    void ReceiveEvent(ViewEvent state) throws BlackjackGUIException;
}
