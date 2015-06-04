package sim.communication;

import java.util.Collection;

public interface Receiver<T> {

	public Collection<Message<T>> receive();
}
