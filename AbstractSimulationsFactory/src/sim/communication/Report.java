package sim.communication;

public class Report {

	private final int individualsCount;
	
	private final int iterationNumber;

	public Report(int individualsCount, int iterationNumber) {
		super();
		this.individualsCount = individualsCount;
		this.iterationNumber = iterationNumber;
	}

	public int getIndividualsCount() {
		return individualsCount;
	}

	public int getIterationNumber() {
		return iterationNumber;
	}
	
}
