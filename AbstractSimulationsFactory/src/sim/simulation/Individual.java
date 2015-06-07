package sim.simulation;

public interface Individual<Col, T extends Individual<Col, T>> {

	public boolean doStep(Grid<Col, T> before, Grid<Col, T> after);
	
	public void moveTo(int x, int y);
}
