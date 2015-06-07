package sim.ants.simulation;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import sim.ants.factory.AntSimulationFactory;

public class Activator implements BundleActivator {
	
	private ServiceRegistration<AntSimulationFactory> simulationRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		BasicAntsSimulationFactory simulationFactory = new BasicAntsSimulationFactory();
		simulationRegistration = context.registerService(AntSimulationFactory.class, simulationFactory, null);
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		simulationRegistration.unregister();
	}

}
