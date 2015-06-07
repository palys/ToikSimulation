package sim.simulation;

import sim.communication.Migration;
import sim.communication.Receiver;

public interface Simulation<C, I extends Individual<C, I>> extends Receiver<Migration<I>> {

	public void doStep();
}
