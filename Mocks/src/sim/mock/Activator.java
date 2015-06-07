package sim.mock;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import sim.communication.Sender;

public class Activator implements BundleActivator {
	
	private ServiceRegistration<Sender> senderRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		Sender sender = new SenderMock();
		
		senderRegistration = context.registerService(Sender.class, sender, null);
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {

		senderRegistration.unregister();
	}

}
