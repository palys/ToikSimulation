package sim.mock;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import sim.communication.Sender;
import sim.factory.SimulationFactoryInterface;

public class Activator implements BundleActivator {
	
	private ServiceRegistration<Sender> senderRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		
		Sender sender = new SenderMock();

		try {
			senderRegistration = context.registerService(Sender.class, sender, null);

			ServiceReference<SimulationFactoryInterface> serviceReference = context.getServiceReference(SimulationFactoryInterface.class);
			SimulationFactoryInterface simulationFactory = context.getService(serviceReference);
			StarterMock starter = new StarterMock(simulationFactory);

			(new Thread(starter)).start();
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {

		senderRegistration.unregister();
	}

}
