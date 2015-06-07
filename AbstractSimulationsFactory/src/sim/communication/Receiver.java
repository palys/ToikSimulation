package sim.communication;

import java.util.Collection;

public interface Receiver<T> {

	public void receive(Collection<Message<T>> messages);
}
