package blackjack.view;

public abstract class ViewEvent {
    public enum ViewEventType {
        UPDATE,
        WIN,
        LOSE
    }
    protected ViewEventType m_type;
    public ViewEventType GetType() {
        return m_type;
    }
}
