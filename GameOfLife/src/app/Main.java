package app;

import java.io.IOException;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
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
		
		
	}
}
