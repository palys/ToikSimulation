package sim.communication;

import java.util.HashMap;
import java.util.Map;

public class Report {

	private final int individualsCount;
	
	private final Map<Object, Integer> colorCount;
	
	public Report(int individualsCount) {
		this.individualsCount = individualsCount;
		this.colorCount = new HashMap<Object, Integer>();
	}

	public int getIndividualsCount() {
		return individualsCount;
	}

	public Map<Object, Integer> getColorCount() {
		return colorCount;
	}
	
}
