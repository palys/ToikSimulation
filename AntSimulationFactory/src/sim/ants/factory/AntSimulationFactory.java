package sim.ants.factory;

import java.util.Properties;

import sim.ants.configuration.Configuration;
import sim.configuration.IncorrectConfigurationException;
import sim.factory.SimulationFactoryInterface;
import sim.simulation.Simulation;

public abstract class AntSimulationFactory implements SimulationFactoryInterface {
	
	protected Configuration configuration;
	
	public AntSimulationFactory() {
		
	}
	
	@Override
	public void configure(Properties properties) throws IncorrectConfigurationException {
		this.configuration = Configuration.of(properties);
		
	}
	
}
