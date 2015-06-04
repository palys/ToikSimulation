package sim.ants.simulation;

import sim.simulation.Grid;
import sim.simulation.Individual;

public class BasicAnt implements Individual<WhiteBlackColor, BasicAnt> {
	
	private int x;
	
	private int y;
	
	private Direction direction;

	public BasicAnt(int x, int y) {
		this(x, y, Direction.UP);
	}
	
	public BasicAnt(int x, int y, Direction dir) {
		this.x = x;
		this.y = y;
		this.direction = dir;
	}

	@Override
	public void doStep(Grid<WhiteBlackColor, BasicAnt> before,
			Grid<WhiteBlackColor, BasicAnt> after) {
		
		WhiteBlackColor color = before.getColor(x, y);
		
		if (color.equals(WhiteBlackColor.BLACK)) {
			direction = direction.turnRight();
		} else {
			direction = direction.turnLeft();
		}
		
		after.set(color.oposite(), x, y);
		after.set(this, x + direction.dx, y + direction.dy); // TODO check if outside grid
		
	}

	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
