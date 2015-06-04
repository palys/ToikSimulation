package sim.ants;

import sim.simulation.Individual;

public interface Ant<Col, A extends Ant<Col, A>> extends Individual<Col, A> {
	
	public abstract int getX();
	
	public abstract int getY();

}
