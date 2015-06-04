package sim.ants.configuration;

import java.util.Properties;

import sim.configuration.AbstractConfiguration;
import sim.configuration.IncorrectConfigurationException;

public class Configuration extends AbstractConfiguration {
	
	private static final String WIDTH = "width";
	
	private static final String HEIGHT = "height";
	
	private static final String COUNT = "count";
	
	private static final String ANT_TYPE = "ant_type";

	private final int width;
	
	private final int height;
	
	private final int startingIndividualsCount;
	
	private final String antType;

	public Configuration(int width, int height, int startingIndividualsCount, String antType) {
		super();
		this.width = width;
		this.height = height;
		this.startingIndividualsCount = startingIndividualsCount;
		this.antType = antType;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getStartingIndividualsCount() {
		return startingIndividualsCount;
	}
	
	public String getAntType() {
		return antType;
	}

	public static Configuration of(Properties properties) throws IncorrectConfigurationException {
		
		try {
			int width = Integer.parseInt(get(properties, WIDTH));
			int height = Integer.parseInt(get(properties, HEIGHT));
			int count = Integer.parseInt(get(properties, COUNT));
			String type = get(properties, ANT_TYPE);
			
			return new Configuration(width, height, count, type);
		} catch (IllegalArgumentException e) {
			throw new IncorrectConfigurationException(e);
		}
	}

}
