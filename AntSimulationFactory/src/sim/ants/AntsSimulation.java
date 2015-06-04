package sim.ants;

import java.util.Collection;

import sim.ants.configuration.Configuration;
import sim.communication.Message;
import sim.communication.Migration;
import sim.simulation.Grid;
import sim.simulation.Individual;
import sim.simulation.Simulation;

public abstract class AntsSimulation<Col, Ant extends Individual<Col, Ant>> implements Simulation {
	
	protected Grid<Col, Ant> grid;
	
	public AntsSimulation(Configuration config) {
		initialize(config);
	}
	
	protected abstract void initialize(Configuration config);

	@Override
	public Collection<Message<Migration>> receive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doStep() {
		Grid<Col, Ant> newGrid = grid.copyWithoutIndividuals();
		
		for (Ant ant : newGrid) {
			ant.doStep(grid, newGrid);
		}
		
		grid = newGrid;

	}

}
