package app;

public class Cell {
	
	private byte state;
	
	public Cell(byte state) {
		this.state = state;
	}
	
	public byte getState() {
		return state;
	}
	
	public void setState(byte state) {
		this.state = state;
	}
}
