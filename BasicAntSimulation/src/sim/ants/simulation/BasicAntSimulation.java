package sim.ants.simulation;

import sim.ants.AntsSimulation;
import sim.ants.configuration.Configuration;
import sim.simulation.Grid;

public class BasicAntSimulation extends AntsSimulation<WhiteBlackColor, BasicAnt> {

	public BasicAntSimulation(Configuration config) {
		super(config);
	}

	@Override
	protected void initialize(Configuration config) {
		grid = new Grid<WhiteBlackColor, BasicAnt>(config.getWidth(), config.getHeight(), WhiteBlackColor.WHITE);
		
	}

	

}
