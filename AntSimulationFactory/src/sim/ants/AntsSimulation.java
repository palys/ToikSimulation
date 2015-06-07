package sim.ants;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import sim.ants.configuration.AddressesDictionary;
import sim.ants.configuration.Configuration;
import sim.communication.Message;
import sim.communication.Migration;
import sim.communication.Report;
import sim.communication.Sender;
import sim.mock.SenderMock;
import sim.simulation.Grid;
import sim.simulation.Simulation;

public abstract class AntsSimulation<Col extends Enum<Col>, A extends Ant<Col, A>> implements Simulation<Col, A> {
	
	protected Grid<Col, A> grid;
	
	private Sender sender;
	
	private AddressesDictionary addressesDictionary;
	
	private final Configuration config;
	
	private int iteration;
	
	public AntsSimulation(Configuration config) {
		sender = new SenderMock(); // FIXME
		addressesDictionary = new AddressesDictionary(); // TODO get from topology
		this.config = config;
		initialize(config);
		iteration = 0;
	}
	
	@Override
	public void receive(Collection<Message<Migration<A>>> messages) {
		
		for (Message<Migration<A>> message : messages) {
			for (A ant : message.getContent()) {
				int x, y;
				
				if (ant.getX() < 0) {
					x = grid.getWidth() - 1;
				} else if (ant.getX() >= grid.getWidth()) {
					x = 0;
				} else {
					x = ant.getX();
				}
				
				if (ant.getY() < 0) {
					y = grid.getHeight() - 1;
				} else if (ant.getY() >= grid.getHeight()) {
					y = 0;
				} else {
					y = ant.getY();
				}
				
				ant.moveTo(x, y);
				grid.set(ant, x, y);
				
			}
		}
	}
	
	protected abstract void initialize(Configuration config);
	
	private void sendReport() {
		Report report = generateReport();
		Message<Report> message = new Message<Report>(report, addressesDictionary.getAddress("starter"), iteration);
		sender.send(message);
	}
	
	protected abstract Report generateReport();

	@Override
	public void doStep() {
		Grid<Col, A> newGrid = grid.copyWithoutIndividuals();
		Map<Direction, Migration<A>> migrations = new HashMap<Direction, Migration<A>>();
		migrations.put(Direction.UP, new Migration<A>());
		migrations.put(Direction.LEFT, new Migration<A>());
		migrations.put(Direction.DOWN, new Migration<A>());
		migrations.put(Direction.RIGHT, new Migration<A>());
		//System.out.println("New grid\n" + newGrid);
		
		for (A ant : grid) {
			if (!ant.doStep(grid, newGrid)) {
				if (ant.getX() < 0) {
					migrations.get(Direction.LEFT).add(ant);
				} else if (ant.getX() >= grid.getWidth()) {
					migrations.get(Direction.RIGHT).add(ant);
				} else if (ant.getY() < 0) {
					migrations.get(Direction.UP).add(ant);
				} else {
					migrations.get(Direction.DOWN).add(ant);
				}
			}
		}
		//System.out.println(toSend.size() + " ants send");
		grid = newGrid;

		send(migrations);
		
		iteration++;
		
		if (iteration % config.getOperationsBetweenReports() == 0) {
			sendReport();
		}
	}
	
	private void send(Map<Direction, Migration<A>> migrations) {
		for (Map.Entry<Direction, Migration<A>> entry : migrations.entrySet()) {
			Migration<A> migration = entry.getValue();
			String address = addressesDictionary.getAddress(entry.getKey().toString());
			Message<Migration<A>> message = new Message<Migration<A>>(migration, address, iteration);
			sender.send(message);
		}
	}
	
	@Override
	public String toString() {
		return grid.toString();
	}

}
