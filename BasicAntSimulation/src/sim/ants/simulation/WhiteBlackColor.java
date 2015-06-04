package sim.ants.simulation;

public enum WhiteBlackColor {
	WHITE, BLACK;
	
	public WhiteBlackColor oposite() {
		if (this.equals(WHITE)) return BLACK;
		return WHITE;
	}
}
