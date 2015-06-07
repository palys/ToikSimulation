package sim.ants.factory;

import java.util.Properties;

import sim.ants.configuration.Configuration;
import sim.configuration.IncorrectConfigurationException;
import sim.factory.SimulationFactoryInterface;
import sim.simulation.Simulation;

public class AntSimulationFactory implements SimulationFactoryInterface {
	
	protected final Configuration configuration;
	
	public AntSimulationFactory(Properties properties) throws IncorrectConfigurationException {
		this.configuration = Configuration.of(properties);
	}
	
	@Override
	public Simulation createSimulation() {
		return null;//TODO
	}



}
