package blackjack.model;

/**
 * An interface for a class that dispatches ModelEvents
 */
public interface Model {
	public void notifyChanged(ModelEvent me);
}