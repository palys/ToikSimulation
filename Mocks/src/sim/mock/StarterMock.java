package sim.mock;

import java.util.Properties;

import sim.configuration.IncorrectConfigurationException;
import sim.factory.SimulationFactoryInterface;
import sim.simulation.Simulation;

public class StarterMock implements Runnable {
	
	private final SimulationFactoryInterface simulationFactory;

	public StarterMock(SimulationFactoryInterface simulationFactory) {
		super();
		this.simulationFactory = simulationFactory;
	}

	@Override
	public void run() {
		System.out.println("RUN");
		Properties properties = new Properties();
		properties.put("width", "100");
		properties.put("height", "100");
		properties.put("count", "100");
		properties.put("ant_type", "basic");
		properties.put("iterations", "10000");
		properties.put("iterations_between_reports", "100");
		
		try {

			simulationFactory.configure(properties);
			
			Simulation sim = simulationFactory.createSimulation();
			
			for (int i = 0; i < Integer.parseInt(properties.getProperty("iterations")); i++) {
				sim.doStep();
			}
			
		} catch (IncorrectConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
