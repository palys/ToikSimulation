package sim.ants.simulation;

public enum Direction {

	UP(0, -1),
	DOWN(0, 1),
	LEFT(-1, 0),
	RIGHT(1, 0);
	
	public final int dx;
	
	public final int dy;
	
	Direction(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public Direction turnLeft() {
		if (this.equals(UP)) return LEFT;
		if (this.equals(LEFT)) return DOWN;
		if (this.equals(DOWN)) return RIGHT;
		return UP;
	}
	
	public Direction turnRight() {
		if (this.equals(UP)) return RIGHT;
		if (this.equals(RIGHT)) return DOWN;
		if (this.equals(DOWN)) return LEFT;
		return UP;
	}
	
}
