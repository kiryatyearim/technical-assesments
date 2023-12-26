package com.kiryatyearim.technical.assesment.google;

import java.util.*;

public class PairSumQuestion {
    public static void main(String[] args) {
        //int[] input = new int[] {1,2,3,9};
        //int[] input = new int[] {1,2,4,4};
        int[] input = new int[] {2,4,1,4};
        int sum = 8;

        //int[] result = getPairSumBruteForce(input, sum);
        //int[] result = getPairSumClosingPointers(input, sum);
        int[] result = getPairSumStoreRemaining(input, sum);
        System.out.println("result: " + Arrays.toString(result));
    }

    private static int[] getPairSumStoreRemaining(int[] input, int sum) {
        int[] result = new int[2];
        // This works when the input array is not given sorted
        List<Integer> remainingSet = new ArrayList<>();
        for (int i : input) {
            Integer remaining = sum - i;
            if (remainingSet.contains(i)) {
                result[0] = remainingSet.get(remainingSet.indexOf(remaining));
                result[1] = i;
                break;
            }
            remainingSet.add(sum - i);
        }
        return result;
    }

    private static int[] getPairSumClosingPointers(int[] input, int sum) {
        Integer p1 = 0;
        Integer p2 = input.length-1;

        return findPairOfPointers(input, sum, p1, p2);

    }

    private static int[] findPairOfPointers(int[] input, int expectedSum, Integer p1, Integer p2) {
        if (p1.compareTo(p2) >= 0) {
            return null;
        }
        int[] result = new int[2];
        int sum = input[p1] + input[p2];
        if (sum == expectedSum) {
            result[0] = input[p1];
            result[1] = input[p2];
            return result;
        }

        if(sum<expectedSum) {
            ++p1;
        } else {
            ++p2;
        }

        return findPairOfPointers(input, expectedSum, p1, p2);
    }

    private static int[] getPairSumBruteForce(int[] input, int expectedSum) {
        int[] result = new int[2];

        // Brute force
        for (int i=0; i<input.length; i++) {
            for (int j=i; j<input.length; j++) {
                int sum = input[i] + input[j];
                if (sum == expectedSum) {
                    result[0] = input[i];
                    result[1] = input[j];
                    break;
                }
            }
        }
        return result;
    }
}
