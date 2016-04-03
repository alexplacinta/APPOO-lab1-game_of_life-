package app;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class Main {
	
	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		
		int indexI = Arrays.asList(args).indexOf("-i");
		int indexN = Arrays.asList(args).indexOf("-n");
		int indexO = Arrays.asList(args).indexOf("-o");
		
		if ((indexI == -1) || (indexN == -1)) {
			System.out.println("Specify required options -i and -n");
			return;
		}
		
		String inputFileLocation = args[indexI + 1];
		int numberOfEvolveIterations = Integer.parseInt(args[indexN + 1]);
		
		GameOfLife gameOfLife = GameOfLife.getInstance();
		
		byte[][] inputGrid = GridFileParser.getInstance().create2DIntGridFromFile(inputFileLocation);
		
		gameOfLife.initializeWorldMap(inputGrid);
		
		gameOfLife.evolve(numberOfEvolveIterations);
		
		if (indexO == -1)
			gameOfLife.outputGenerationInConsole();
		else
			gameOfLife.outputGenerationInFile(args[indexO + 1]);
		
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println("Finished in: " + (double)estimatedTime / 1000000000.0 + " seconds.");
	}
}
