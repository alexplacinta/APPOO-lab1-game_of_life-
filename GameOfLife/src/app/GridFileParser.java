package app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GridFileParser {
	private static GridFileParser parser = new GridFileParser();
	
	private GridFileParser() {
		
	}
	
	public static GridFileParser getInstance() {
		return parser;
	}
	
	public byte[][] create2DIntGridFromFile(String fileLocation) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(fileLocation));
		
		byte[][] grid = null;
		String line;
		List<String> list = new ArrayList<String>();
		
		while ((line = buffer.readLine()) != null) {
		    list.add(line);
		}
		
		grid = new byte[list.size()][list.get(0).length()];
		int i = 0;
		for (String l : list) {
			for (int j = 0; j < l.length(); j++) {
				grid[i][j] = (byte) (l.charAt(j) - 48);
			}
			i++;
		}
		
		return grid;
	}
}
