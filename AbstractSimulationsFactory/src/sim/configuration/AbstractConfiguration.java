package sim.configuration;

import java.util.Properties;

public abstract class AbstractConfiguration {

	protected static String get(Properties props, String key) {
		
		if (!props.containsKey(key)) {
			throw new IllegalArgumentException("Configuration properties do not contain key " + key);
		}
		
		return props.getProperty(key);
	}
}
