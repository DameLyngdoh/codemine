package com.damelyngdoh.codemine.islandcount;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Dame Lyngdoh
 *
 */
public class IslandCount {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int row = in.nextInt();
		int column = in.nextInt();
		int array[][] = new int[row][column];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				array[i][j] = in.nextInt();
			}
		}
		in.close();
		
		countIsland(array);
	}
	
	/**
	 * Counts the number of islands in the input array.
	 * @param array Input array.
	 */
	public static void countIsland(int[][] array) {
		int islandCount = 0;
		int largestIsland = 0;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				// If 1 is found then an island is located
				if(array[i][j] == 1) {
					// Island count is updated
					islandCount++;
					
					// Traversing all the tiles that are immediately adjacent or indirectly adjacent to first tile
					int currentIslandSize = bfs(array, i, j);
					
					// Update largest island variable by checking it against current island size
					largestIsland = currentIslandSize > largestIsland ? currentIslandSize : largestIsland;
				}
			}
		}
		
		if(islandCount > 0) {
			System.out.println("Numeber of islands: " + islandCount);
			System.out.println("Largest island has " + largestIsland + " tiles.");
		} else {
			System.out.println("No islands were found.");
		}
		
	}
	
	/**
	 * Gets a list of all adjacent tiles to the tile specified by method parameters.
	 * @param array Input array.
	 * @param row Row index of the tile.
	 * @param column Column index of the tile.
	 * @return List of Coordinate objects representing the adjacent tiles.
	 */
	public static List<Coordinate> getAdjacentTiles(int[][] array, int row, int column) {
		// There are exactly 4 locations for tiles to be present
		List<Coordinate> adjacentTiles = new ArrayList<Coordinate>(4);
		
		// Tile above
		if(row > 0 && array[row - 1][column] == 1) {
			adjacentTiles.add(new Coordinate(row - 1, column));
		}
		
		// Tile to the right
		if(column < array[0].length - 1 && array[row][column + 1] == 1) {
			adjacentTiles.add(new Coordinate(row, column + 1));
		}
		
		// Tile below
		if(row < array.length - 1 && array[row + 1][column] == 1) {
			adjacentTiles.add(new Coordinate(row + 1, column));
		}
				
		// Tile to the left
		if(column > 0 && array[row][column - 1] == 1) {
			adjacentTiles.add(new Coordinate(row, column - 1));
		}
		return adjacentTiles;
	}
	
	/**
	 * Breadth First Traversal method starting from the specified node and traverses all tiles in the island.
	 * @param array Input array of tiles.
	 * @param row Row index of root node to start BFT.
	 * @param column Column index of root node to start BFT.
	 * @return Number of tiles that compose the island.
	 */
	public static int bfs(int[][] array, int row, int column) {
		// Marking the current location as 0, to indicate it has been visited
		array[row][column] = 0;
		
		// Initializing the size of the current island
		int currentIslandSize = 1;
		
		// Queue to hold the tiles that are not visited but are part of the island
		Queue<Coordinate> queue = new ArrayDeque<Coordinate>();
		
		// Adds all the adjacent tiles to the first tile to the queue
		queue.addAll(getAdjacentTiles(array, row, column));
		
		// While there are tiles in the queue, then traverse
		while(!queue.isEmpty()) {
			// Popping next tile from the queue
			Coordinate currentLocation = queue.poll();
			
			// Updating tile count
			currentIslandSize++;
			
			// Marking current tile as visited
			array[currentLocation.row][currentLocation.column] = 0;
			
			// Getting all adjacent tiles and adding them to the queue
			queue.addAll(getAdjacentTiles(array, currentLocation.row, currentLocation.column));
		}
		return currentIslandSize;
	}
}

/**
 * Class representing a coordinate of a tile, 
 * that is row and column index of a tile.
 * 
 * @author dame lyngdoh
 *
 */
class Coordinate {
	public int row;
	public int column;
	public Coordinate(int row, int column) {
		this.row = row; this.column = column;
	}
}