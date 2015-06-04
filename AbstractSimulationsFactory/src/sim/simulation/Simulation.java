package sim.simulation;

import sim.communication.Migration;
import sim.communication.Receiver;

public interface Simulation extends Receiver<Migration> {

	public void doStep();
}
