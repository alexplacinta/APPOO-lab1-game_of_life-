package app;

import java.util.concurrent.*;

public class WorldMap {
	ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	
	private TwoSizeBufferCellGrid buffer;

	public WorldMap(byte[][] inputGrid) {
		
		buffer = new TwoSizeBufferCellGrid(
				new CellGrid(inputGrid), 
				new CellGrid(inputGrid));
	}

	public void evolve() {
		final CellGrid currentGrid = buffer.getCurrentCellGrid();
		final CellGrid anotherGrid = buffer.getAnotherCellGrid();
		
		
		try {
			for (int i = 0; i < currentGrid.getYLength(); i++) {
				for (int j = 0; j < currentGrid.getXLength(); j++) {
					final int ii = i;
					final int jj = j;
					exec.submit(new Runnable() {
			            @Override
			            public void run() {
			            	int aliveNeighbours = currentGrid.getNumAliveNeighbours(ii, jj);
							
							if ((aliveNeighbours < 2) || (aliveNeighbours > 3)) {
								anotherGrid.setState(ii, jj, (byte)0);
							} else if (aliveNeighbours == 3) {
								anotherGrid.setState(ii, jj, (byte)1);
							} else {
								anotherGrid.setState(ii, jj, currentGrid.getState(ii, jj));
							}
			            }
			        });
					
				}
			}
		
		} finally {
//			exec.shutdown();
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
