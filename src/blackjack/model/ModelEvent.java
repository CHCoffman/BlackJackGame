package blackjack.model;

/**
 * An information packet giving the model information about what user events have occured
 */
public class ModelEvent {
	/**
	 * The type of model event
	 */
	public enum EventType {
		HIT,
		STAND,
		SPLIT,
		FOLD,
	}
	private EventType m_type;

	/**
	 * A model event is passed to the model from the view
	 * @param t The type of event
	 */
	public ModelEvent(EventType t) {
		m_type = t;
	}

	/**
	 * Gets the type of the model event
	 * @return The model event EventType
	 */
	public EventType GetType() {
		return m_type;
	}
}