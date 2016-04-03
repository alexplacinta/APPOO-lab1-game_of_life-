package app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class GameOfLife {
	private static GameOfLife instance = new GameOfLife();
	
	private WorldMap worldMap;
	
	private GameOfLife() {
		
	}
	
	public static GameOfLife getInstance() {
		return instance;
	}
	
	
	public void initializeWorldMap(byte[][] grid) {
		this.worldMap = new WorldMap(grid);
	}
	
	public void evolve(int n) {
		for (int i = 0; i < n; i++) {
			worldMap.evolve();
		}
	}
	
	public void outputGenerationInConsole() {
		System.out.print(worldMap);
	}
	
	public void outputGenerationInFile(String fileLocation) throws FileNotFoundException {
		try(  PrintWriter out = new PrintWriter(fileLocation)  ){
		    out.println(worldMap.toString());
		}
	}
}
