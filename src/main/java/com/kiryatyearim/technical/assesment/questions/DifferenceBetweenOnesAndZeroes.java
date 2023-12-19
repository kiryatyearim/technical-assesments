package com.kiryatyearim.technical.assesment.questions;

import java.util.Arrays;

public class DifferenceBetweenOnesAndZeroes {
    public static void main(String[] args) {
        int[][] input = {{0,1,1},{1,0,1},{0,0,1}};
        //int[][] input = {{1,1},{1,1},{1,1}};
        int[][] result = onesMinusZeros(input);
        for (int i=0; i<result.length; i++) {
            System.out.println("result: " + Arrays.toString(result[i]));
        }

    }

    public static int[][] onesMinusZeros(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                int oneCount = numCount(1, grid, i, j);
                int zeroCount = numCount(0, grid, i, j);
                result[i][j] = oneCount - zeroCount;
            }
        }

        return result;
    }

    public static int numCount(int num, int[][] grid, int row, int col) {
        int rowCount = 0;
        for (int i=0; i<grid[row].length; i++) {
            if (grid[row][i] == num) {
                rowCount++;
            }
        }

        int colCount = 0;
        for (int i=0; i<grid.length; i++) {
            if (grid[i][col] == num) {
                colCount++;
            }
        }
        return rowCount + colCount;
    }

}
