package app;

public class CellGrid {
	Cell[][] grid;

	public CellGrid(byte[][] grid) {
		this.grid = new Cell[grid.length][grid[0].length];
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				this.grid[i][j] = new Cell(grid[i][j]);
			}
		}
	}
	
	public int getXLength() {
		return grid[0].length;
	}
	
	public int getYLength() {
		return grid.length;
	}

	public int getNumAliveNeighbours(int i, int j) {
		int numberOfAliveNeighbours = 0;
		
		for (int m = i - 1; m <= i + 1; m++) {
			for (int n = j - 1; n <= j + 1; n++) {
				
				if ((m == i) && (n == j)) continue;
				
				int circularM = (m + getYLength()) % getYLength();
				int circularN = (n + getXLength()) % getXLength();
				
				if (grid[circularM][circularN].getState() == 1)
					numberOfAliveNeighbours++;
			}
		}
		
		return numberOfAliveNeighbours;
	}

	public void setState(int i, int j, byte k) {
		grid[i][j].setState(k);
		
	}

	public byte getState(int i, int j) {
		return grid[i][j].getState();
	}
	
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < getYLength(); i++) {
			for (int j = 0; j < getXLength(); j++) {
				result += grid[i][j].getState();
			}
			result += '\n';
		}
		
		return result;
	}

}
