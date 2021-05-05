package blackjack.view;

/**
 * An event handled by a ViewEventListener
 */
public abstract class ViewEvent {
    public enum ViewEventType {
        UPDATE,
        WIN,
        LOSE
    }
    protected ViewEventType m_type;

    /**
     * Gets the ViewEvent's type
     * @return The ViewEvent's type
     */
    public ViewEventType GetType() {
        return m_type;
    }
}
