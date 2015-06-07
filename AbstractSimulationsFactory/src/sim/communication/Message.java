package sim.communication;

public class Message<T> {
	
	private final String address;
	
	private final T content;
	
	private final int iteration;
	
	public Message(T content, String address, int iteration) {
		this.content = content;
		this.address = address;
		this.iteration = iteration;
	}

	public T getContent() {
		return content;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getIteration() {
		return iteration;
	}
}
