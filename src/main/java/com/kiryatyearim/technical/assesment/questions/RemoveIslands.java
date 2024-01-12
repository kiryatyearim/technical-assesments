package com.kiryatyearim.technical.assesment.questions;

public class RemoveIslands {

    public static void main(String[] args) {
        int[][] input = {
                {1,0,0,0,0,0},
                {0,1,0,1,1,1},
                {0,0,1,0,1,0},
                {1,1,0,0,1,0},
                {1,0,1,1,0,0},
                {1,0,0,0,0,1},
        };

        print(input);
        removeIslands(input);
        print(input);

    }

    private static void print(int[][] input) {
        System.out.println();
        for (int i=0; i<input.length; i++) {
            for (int j=0; j<input[i].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }

    }
    private static void removeIslands(int[][] input) {

        for (int i=1; i<input.length; i++) {
            for (int j=0; j<input[i].length; j++) {
                if (input[i][j]==1 && isIsland(i, j, input)) {
                    input[i][j]=0;
                }
            }
        }
    }

    private static boolean isIsland(int row, int col, int[][] input) {

        boolean isLinked = false;
        if (input[row][0] == 1) {
            isLinked = true;
            for (int j=0; j<col; j++) {
                if (input[row][j] == 0) {
                    isLinked = false;
                    break;
                }
            }
        }

        if (isLinked) {
            return false;
        }

        if (input[row][input[row].length-1] == 1) {
            isLinked = true;
            for (int j=col; j<input[row].length-1; j++) {
                if (input[row][j] == 0) {
                    isLinked = false;
                    break;
                }
            }
        }

        if (isLinked) {
            return false;
        }

        if (input[0][col] == 1) {
            isLinked = true;
            for (int i=0; i<col; i++) {
                if (input[i][col] == 0) {
                    isLinked = false;
                    break;
                }
            }
        }

        if (isLinked) {
            return false;
        }

        if (input[input.length-1][col] == 1) {
            isLinked = true;
            for (int i=col; i<input.length-1; i++) {
                if (input[i][col] == 0) {
                    isLinked = false;
                    break;
                }
            }
        } else {
            isLinked = false;
        }

        return !isLinked;
    }


}
