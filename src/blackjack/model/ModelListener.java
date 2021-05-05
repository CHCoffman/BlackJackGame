package blackjack.model;

/**
 * An interface for objects that receive ModelEvents
 */
public interface ModelListener {
	/**
	 * A function that is called that processes/updates based on the ModelEvent given
	 * @param me
	 */
	void modelChanged(ModelEvent me);
}
