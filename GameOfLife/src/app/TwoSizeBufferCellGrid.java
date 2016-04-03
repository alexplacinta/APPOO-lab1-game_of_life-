package app;

import java.lang.reflect.Array;

public class TwoSizeBufferCellGrid {
	private CellGrid[] buffer = new CellGrid[2];
	private int pointerToCurrentElement = 0;
	
	public TwoSizeBufferCellGrid(CellGrid first, CellGrid second) {
		buffer[0] = first;
		buffer[1] = second;
	}
	
	public CellGrid getCurrentCellGrid() {
		return buffer[pointerToCurrentElement];
	}
	
	public CellGrid getAnotherCellGrid() {
		return buffer[(pointerToCurrentElement + 1) % 2];
	}
	
	public void switchPointer() {
		pointerToCurrentElement = (pointerToCurrentElement + 1) % 2;
	}
}
