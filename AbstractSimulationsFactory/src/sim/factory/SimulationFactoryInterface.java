package sim.factory;

import java.util.Properties;

import sim.configuration.IncorrectConfigurationException;
import sim.simulation.Simulation;

public interface SimulationFactoryInterface {

	public Simulation createSimulation() throws IncorrectConfigurationException;
	
	public void configure(Properties properties) throws IncorrectConfigurationException;
}
