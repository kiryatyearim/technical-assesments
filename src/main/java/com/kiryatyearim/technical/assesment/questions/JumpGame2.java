package com.kiryatyearim.technical.assesment.questions;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] input = {2,3,1,1,4};
        int output = getNumJumps(input);
        System.out.println("Num jumps: " + output);
    }

    private static int getNumJumps(int[] input) {
        int counter = 0;
        int l=0, r=0, farthest;
        while (r < input.length-1) {
            farthest=0;
            for (int i = l; i < r+1; i++) {
                farthest = Math.max(farthest, i + input[i]);
            }
            l = r + 1;
            r = farthest;
            counter++;
        }
        return counter;
    }
}
