package sim.factory;

import java.util.Properties;

public interface AbstractSimulationFactory {

	public SimulationFactoryInterface createFactory(Properties properties);
}
