package sim.ants.simulation;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import sim.factory.SimulationFactoryInterface;

public class Activator implements BundleActivator {
	
	private ServiceRegistration<SimulationFactoryInterface> simulationRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Start BasicAntSimulation");
		BasicAntsSimulationFactory simulationFactory = new BasicAntsSimulationFactory();
		simulationRegistration = context.registerService(SimulationFactoryInterface.class, simulationFactory, null);
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		simulationRegistration.unregister();
	}

}
