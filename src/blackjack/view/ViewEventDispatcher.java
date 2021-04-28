package blackjack.view;
import blackjack.view.GameState;
import blackjack.view.ViewEventListener;
import blackjack.view.ViewExceptions.BlackjackGUIException;

import java.util.ArrayList;

public class ViewEventDispatcher {
    private ArrayList<ViewEventListener> m_receivers;
    public void DispatchEvent(GameState s) throws BlackjackGUIException {
        for(ViewEventListener listener : m_receivers) {
            listener.ReceiveEvent(s);
        }
    }
    public void AddListener(ViewEventListener listener) {
        m_receivers.add(listener);
    }
}
