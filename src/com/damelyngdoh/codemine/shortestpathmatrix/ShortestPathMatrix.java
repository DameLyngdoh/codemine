package com.damelyngdoh.codemine.shortestpathmatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShortestPathMatrix {
    
    private static Coordinate destination = null;
    private static int destinationValue = -1;

    /**
    private static int[][] SAMPLE = {
        {1, 2, 2},
        {1, 1, 1},
        {1, 2, 2}
    };
     */

    public static void main(String[] args) {
        int[][] matrix = null;
        try(Scanner in = new Scanner(System.in)) {
            int row = in.nextInt();
            int column = in.nextInt();

            matrix = new int[row][column];
            for(int i = 0, j = 0; i < row; i++) {
                for(j = 0; j < column; j++)
                    matrix[i][j] = in.nextInt();
            }
            destination = new Coordinate(matrix.length - 1, matrix[0].length - 1);
            destinationValue = matrix[destination.getRow()][destination.getColumn()];
        }
        List<Coordinate> shortestPath = calculatePath(matrix);
        for(Coordinate c : shortestPath) {
            System.out.println(c);
        }
    }

    public static List<Coordinate> calculatePath(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        /**
         * Cost matrix to calculate intermediate results and the cost to the destination
         * cell from each cell.
         */
        int[][] costMatrix = new int[row][column];
        for(int i = 0, j = 0; i < row; i++) {
            for(j = 0; j < column; j++) {
                costMatrix[i][j] = -1;
            }
        }

        // Save this method call to get the cost of the shortest path.
        calculateCost(matrix, costMatrix, new Coordinate(0, 0));
        List<Coordinate> path = new ArrayList<>(row + column);
        for(Coordinate current = new Coordinate(0, 0); !current.equals(destination); current = findNextStep(costMatrix, current)) {
            path.add(current);
        }
        path.add(destination);
        return path;
    }

    public static int calculateCost(int[][] matrix, int[][] cache, Coordinate current) {
        int row = current.getRow();
        int column = current.getColumn();
        
        // If cost already calculated
        if(cache[row][column] != -1) {
            return cache[row][column];
        }

        // If current cell is adjacent to destination cell then calculate cost directly
        if(current.isAdjacent(destination)) {
            cache[row][column] = matrix[row][column] + destinationValue;
            return cache[row][column];
        }
        int rightCost = column < matrix[row].length - 1 ? calculateCost(matrix, cache, current.goRight()) : -1;
        int downCost = row < matrix.length - 1 ? calculateCost(matrix, cache, current.goDown()) : -1;

        if(rightCost == -1 && downCost == -1) {
            cache[row][column] = matrix[row][column];
        }
        else if(rightCost == -1) {
            cache[row][column] = matrix[row][column] + downCost;
        }
        else if(downCost == -1) {
            cache[row][column] = matrix[row][column] +rightCost;
        } 
        else {
            cache[row][column] = matrix[row][column] + Math.min(rightCost, downCost);
        }
        return cache[row][column];
    }

    /**
     * Find the next adjacent cell with the least cost.
     */
    public static Coordinate findNextStep(int[][] costMatrix, Coordinate current) {
        int currentRow = current.getRow();
        int currentColumn = current.getColumn();
        int matrixRow = costMatrix.length - 1;
        int matrixColumn = costMatrix[currentRow].length - 1;
        if(currentRow >= matrixRow && currentColumn >= matrixColumn) {
            return current;
        }
        if(currentRow >= matrixRow) {
            return new Coordinate(currentRow, currentColumn + 1);
        }
        if(currentColumn >= matrixColumn) {
            return new Coordinate(currentRow + 1, currentColumn);
        }
        int downCost = costMatrix[currentRow + 1][currentColumn];
        int rightCost = costMatrix[currentRow][currentColumn + 1];
        return downCost < rightCost ? new Coordinate(currentRow + 1, currentColumn) :  new Coordinate(currentRow, currentColumn + 1);
    }

    /**
     * Use this to debug and print a matrix.
     */
    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public static class Coordinate {
        int row;
        int column;

        public Coordinate(int row, int column) {
            this.row = row; this.column = column;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public boolean isAdjacent(Coordinate coordinate) {
            return isAdjacent(coordinate.getRow(), coordinate.getColumn());
        }

        public boolean isAdjacent(int row, int column) {
            return (row == this.row && Math.abs(column - this.column) == 1) || (column == this.column && Math.abs(row - this.row) == 1);
        }

        public Coordinate goRight() {
            return new Coordinate(row, column + 1);
        }

        public Coordinate goDown() {
            return new Coordinate(row + 1, column);
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)", row, column);
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null) {
                return false;
            }
            if(!(obj instanceof Coordinate)) {
                return false;
            }
            Coordinate coordinate = (Coordinate)obj;
            return this.row == coordinate.getRow() && this.column == coordinate.getColumn();
        }
    }
}
