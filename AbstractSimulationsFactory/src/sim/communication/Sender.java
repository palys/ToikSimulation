package sim.communication;

import java.util.Collection;

public interface Sender {

	public void send(Collection<Message<?>> messages);
}
