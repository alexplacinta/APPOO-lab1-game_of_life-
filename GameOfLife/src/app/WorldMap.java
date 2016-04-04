package app;

public class WorldMap {
	/** actual grid */
	private CellGrid currentGrid;
	/** buffer grid that help to perform processing */
	private CellGrid bufferGrid;

	public WorldMap(byte[][] inputGrid) {
		currentGrid = new CellGrid(inputGrid);
		bufferGrid = new CellGrid(inputGrid);
	}

	public void evolve() {
		
		for (int i = 0; i < currentGrid.getYLength(); i++) {
			for (int j = 0; j < currentGrid.getXLength(); j++) {
				int aliveNeighbours = currentGrid.getNumAliveNeighbours(i, j);
				
				if ((aliveNeighbours < 2) || (aliveNeighbours > 3)) {
					bufferGrid.setState(i, j, (byte)0);
				} else if (aliveNeighbours == 3) {
					bufferGrid.setState(i, j, (byte)1);
				} else {
					bufferGrid.setState(i, j, currentGrid.getState(i, j));
				}
			}
		}
		
		switchCurrentGridWithBuffer();
	}
	
	private void switchCurrentGridWithBuffer() {
		CellGrid tempGrid = bufferGrid;
		bufferGrid = currentGrid;
		currentGrid = tempGrid;
	}
	
	@Override
	public String toString() {
		return currentGrid.toString();
	}

}
