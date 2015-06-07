package sim.ants.simulation;

import java.util.Properties;

import sim.ants.factory.AntSimulationFactory;
import sim.configuration.IncorrectConfigurationException;
import sim.simulation.Simulation;

public class BasicAntsSimulationFactory extends AntSimulationFactory {

	public BasicAntsSimulationFactory() {
		
	}

	@Override
	public Simulation createSimulation() throws IncorrectConfigurationException {
		
		if (this.configuration == null) {
			throw new IncorrectConfigurationException("Factory is not configured.");
		}
		
		return new BasicAntSimulation(this.configuration);
	}

}
