package com.kiryatyearim.technical.assesment.questions;

import java.util.Arrays;

public class SudokuQUestion {
    public static void main(String[] args) {
        int[][] input = {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9},
        };

        boolean result = solveSudoku(input, 0, 0);

        for (int[] r : input) {
            System.out.println("result: " + Arrays.toString(r));
        }

    }

    static boolean solveSudoku(int[][] sudoku, int row, int col) {

        if (row == sudoku.length-1 && col==sudoku.length) {
            return true;
        }

        if (col == sudoku.length) {
            row++;
            col = 0;
        }

        if (sudoku[row][col] != 0) {
            return solveSudoku(sudoku, row, col+1);
        }

        for (int num=1; num<10; num++) {
            if (isValid(sudoku, row, col, num)) {
                sudoku[row][col] = num;

                if (solveSudoku(sudoku, row, col+1)) {
                    return true;
                }
            }
        }
        sudoku[row][col] = 0;
        return false;
    }

    static boolean isValid(int[][] sudoku, int row, int column, int value) {
        for (int x=0; x<sudoku.length; x++) {
            if (sudoku[row][x] == value) {
                return false;
            }
        }
        for (int x=0; x<sudoku.length; x++) {
            if (sudoku[x][column] == value) {
                return false;
            }
        }

        int startRow = row - row%3, startCol = column - column%3;

        for (int i=startRow; i<startRow+3; i++) {
            for (int j=startCol; j<startCol+3; j++) {
                if (sudoku[i][j]==value) {
                    return false;
                }
            }
        }
        return true;
    }


}


