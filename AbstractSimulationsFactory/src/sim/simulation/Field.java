package sim.simulation;

public class Field<Col, Ind> {

	private final Col color;
	
	private final Ind individual;

	public Field(Col color, Ind individual) {
		super();
		this.color = color;
		this.individual = individual;
	}

	public Col getColor() {
		return color;
	}

	public Ind getIndividual() {
		return individual;
	}
	
	public boolean isEmpty() {
		return individual == null;
	}

}
