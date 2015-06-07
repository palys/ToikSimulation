package sim.ants.simulation;

import sim.ants.Ant;
import sim.ants.Direction;
import sim.simulation.Grid;

public class BasicAnt implements Ant<WhiteBlackColor, BasicAnt> {
	
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
	public boolean doStep(Grid<WhiteBlackColor, BasicAnt> before,
			Grid<WhiteBlackColor, BasicAnt> after) {
		
		WhiteBlackColor color = before.getColor(x, y);
		
		if (color.equals(WhiteBlackColor.BLACK)) {
			direction = direction.turnRight();
		} else {
			direction = direction.turnLeft();
		}
		
		after.set(color.oposite(), x, y);
		//System.out.println("After set: color = " + color.oposite() + " at (" + x + ", " + y + ")");
		x += direction.dx;
		y += direction.dy;
		
		if (x >= 0 && x < after.getWidth() && y >= 0 && y < after.getHeight()) {
			after.set(this, x, y);
			return true;
		}
		
		return false;
		//System.out.println("Individual set at (" + (x + direction.dx) + ", " + (y + direction.dy) + ")");
		
	}

	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Basic ant at (" + x + ", " + y + ")";
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

}
