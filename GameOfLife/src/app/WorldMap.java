package app;

public class WorldMap {
	
	private TwoSizeBufferCellGrid buffer;

	public WorldMap(byte[][] inputGrid) {
		
		buffer = new TwoSizeBufferCellGrid(
				new CellGrid(inputGrid), 
				new CellGrid(inputGrid));
	}

	public void evolve() {
		CellGrid currentGrid = buffer.getCurrentCellGrid();
		CellGrid anotherGrid = buffer.getAnotherCellGrid();
		
		for (int i = 0; i < currentGrid.getYLength(); i++) {
			for (int j = 0; j < currentGrid.getXLength(); j++) {
				int aliveNeighbours = currentGrid.getNumAliveNeighbours(i, j);
				
				if ((aliveNeighbours < 2) || (aliveNeighbours > 3)) {
					anotherGrid.setState(i, j, (byte)0);
				} else if (aliveNeighbours == 3) {
					anotherGrid.setState(i, j, (byte)1);
				} else {
					anotherGrid.setState(i, j, currentGrid.getState(i, j));
				}
			}
		}
		
		buffer.switchPointer();
		
	}
	
	// this will point to current grid of cells from buffer
	private CellGrid getCurrentGrid() {
		return buffer.getCurrentCellGrid();
	}
	
	@Override
	public String toString() {
		CellGrid grid = getCurrentGrid();
		
		return grid.toString();
	}

}
