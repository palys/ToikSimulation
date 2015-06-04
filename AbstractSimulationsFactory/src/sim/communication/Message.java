package sim.communication;

public class Message<T> {
	
	private final String address;
	
	private final T content;
	
	public Message(T content, String address) {
		this.content = content;
		this.address = address;
	}

	public T getContent() {
		return content;
	}
	
	public String getAddress() {
		return address;
	}
}
