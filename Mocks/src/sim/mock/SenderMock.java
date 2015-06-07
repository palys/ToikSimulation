package sim.mock;

import sim.communication.Message;
import sim.communication.Sender;

public class SenderMock implements Sender {

	@Override
	public void send(Message<?> message) {
		System.out.println(message);
		
	}

}
