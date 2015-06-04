package sim.ants.simulation;

import java.util.Collection;
import java.util.Random;

import sim.ants.AntsSimulation;
import sim.ants.configuration.Configuration;
import sim.communication.Message;
import sim.communication.Migration;
import sim.simulation.Grid;

public class BasicAntSimulation extends AntsSimulation<WhiteBlackColor, BasicAnt> {
	
	private Random random;

	public BasicAntSimulation(Configuration config) {
		super(config);
	}

	@Override
	protected void initialize(Configuration config) {
		random = new Random();
		this.grid = new Grid<WhiteBlackColor, BasicAnt>(config.getWidth(), config.getHeight(), WhiteBlackColor.WHITE);
		fillGrid(config);
	}

	private void fillGrid(Configuration config) {
		for (int i = 0; i < config.getStartingIndividualsCount(); i++) {
			addAntAtRandomPos();
		}
	}
	
	private void addAntAtRandomPos() {
		int x, y;
		
		do {
			x = random.nextInt(grid.getWidth());
			y = random.nextInt(grid.getHeight());
		} while (!grid.isOccupied(x, y));
		
		grid.set(new BasicAnt(x, y), x, y);
	}

}
