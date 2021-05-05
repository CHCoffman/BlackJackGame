package blackjack.model;

import java.util.List;
import java.util.ArrayList;

/**
 * An abstract class allowing classes to notify ModelListeners of ModelEvents
 */
public abstract class AbstractModel implements Model {
	
	private List<ModelListener> listeners = new ArrayList<ModelListener>(5);

	/**
	 * Notify all of the AbstractModel's listeners that an event has occured
	 * @param event The event to notify with
	 */
	public void notifyChanged(ModelEvent event) {
		for(ModelListener ml : listeners){
			ml.modelChanged(event);
		}
	}

	/**
	 * Adds a ModelListener to the AbstractModel
	 * @param l The listener to add
	 */
	public void addModelListener(ModelListener l){
		listeners.add(l);
	}

	/**
	 * Remove a ModelListener from the abstract model
	 * @param l The model to remove
	 */
	public void removeModelListener(ModelListener l){
		listeners.remove(l);
	}

}