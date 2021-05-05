package blackjack.view;
import blackjack.view.GameState;
import blackjack.view.ViewEventListener;
import blackjack.view.ViewExceptions.BlackjackGUIException;

import java.util.ArrayList;

public class ViewEventDispatcher {
    private ArrayList<ViewEventListener> m_receivers = new ArrayList<>();

    /**
     * Dispatches a view event to all of the dispatcher's listeners
     * @param s The GameState to act as the view event
     * @throws BlackjackGUIException If the listener's receive event function throws
     */
    public void DispatchEvent(ViewEvent s) throws BlackjackGUIException {
        for(ViewEventListener listener : m_receivers) {
            listener.ReceiveEvent(s);
        }
    }

    /**
     * Adds a new view event listener to the dispatcher.
     * @param listener The listener to add
     */
    public void AddListener(ViewEventListener listener) {
        m_receivers.add(listener);
    }
}
