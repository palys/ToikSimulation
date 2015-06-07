package sim.simulation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Grid<Col, Ind extends Individual<Col, Ind>> implements Iterable<Ind> {

	private final Field<Col, Ind>[][] grid;
	
	private final int width;
	
	private final int height;
	
	private final Col initColor;
	
	@SuppressWarnings("unchecked")
	public Grid(int width, int height, Col initColor) {
		grid = new Field[width][height];
		this.width = width;
		this.height = height;
		this.initColor = initColor;
		
		fillWithColor(initColor);
	}
	
	private void fillWithColor(Col color) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				grid[i][j] = new Field<Col, Ind>(color, null);
			}
		}
	}
	
	public Ind get(int x, int y) {
		return grid[x][y].getIndividual();
	}
	
	public boolean isOccupied(int x, int y) {
		return grid[x][y] != null;
	}

	@Override
	public Iterator<Ind> iterator() {
		return new Iterator<Ind>() {
			
			int x = -1, y = 0;
			
			private boolean goToNext() {
				
				for (int i = x + 1; i < width; i++) {
					if (!grid[i][y].isEmpty()) {
						x = i;
						return true;
					}
				}
				
				for (int j = y + 1; j < height; j++) {
					for (int i = 0; i < width; i++) {
						if (!grid[i][j].isEmpty()) {
							x = i;
							y = j;
							return true;
						}
					}
				}
				
				x = -1;
				y = -1;
				
				return false;
			}
			
			{
				goToNext();
			}

			@Override
			public boolean hasNext() {
				
				return (x >= 0) && (y >= 0) && !grid[x][y].isEmpty();
			}

			@Override
			public Ind next() {
				
				Ind individual = null;
				
				if (hasNext()) {
					individual = grid[x][y].getIndividual();
					goToNext();
				} else {
					throw new NoSuchElementException();
				}
				
				return individual;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public void set(Col color, int x, int y) {
		grid[x][y] = new Field<Col, Ind>(color, grid[x][y].getIndividual());
	}
	
	public void set(Ind individual, int x, int y) {
		//System.out.println("Set at (" + x + ", " + y + ")");
		grid[x][y] = new Field<Col, Ind>(grid[x][y].getColor(), individual);
	}
	
	public void set(Field<Col, Ind> field, int x, int y) {
		grid[x][y] = field;
	}
	
	public Col getColor(int x, int y) {
		return grid[x][y].getColor();
	}
	
	public Ind getIndividual(int x, int y) {
		return grid[x][y].getIndividual();
	}
	
	public Grid<Col, Ind> copyWithoutIndividuals() {
		Grid<Col, Ind> newGrid = new Grid<Col, Ind>(width, height, initColor);
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				newGrid.set(getColor(i, j), i, j);
			}
		}
		
		return newGrid;
		
	}
	
	public Collection<Ind> getNeighbors(int x, int y) {
		Collection<Ind> neighbors = new HashSet<Ind>();
		
		//TODO
		
		return neighbors;
	}
	
	public int getColorCount(Col color) {
		int count = 0;
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (grid[i][j].getColor().equals(color)) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public int getIndividualsCount() {
		int count = 0;
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!grid[i][j].isEmpty()) {
					count++;
				}
			}
		}
		
		return count;
	}
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		for (Ind i : this) {
			b.append(i.toString()).append("\n");
		}
		return b.toString();
	}

}
