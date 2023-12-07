package com.kiryatyearim.technical.assesment.questions;

import java.util.Arrays;

public class SawtootQuestion {

    public static void main(String[] args) {
        long[] input = {9, 8, 7, 6, 5, 9, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 9, 8, 7, 6, 5, 9, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 9, 8, 7, 6, 5, 9, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 9, 8, 7, 6, 5, 9, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 9, 8, 7, 6, 5, 9, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 9, 8, 7, 6, 5, 9, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 9, 8, 7, 6, 5, 9, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 9, 8, 7, 6, 5, 9, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5, 8, 7, 6, 5};
        long start = System.currentTimeMillis();
        long result = solution(input);
        System.out.println("result: " + result);
        long end = System.currentTimeMillis();
        System.out.println("last: " + (end-start));
    }

    static long solution(long[] arr) {

        int count = 0;

        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<=arr.length; j++) {
                //long[] subArr = new long[j-i];
                //System.arraycopy(arr, i, subArr, 0, j-i);
                long[] subArr = Arrays.copyOfRange(arr, i, j);
                boolean isSawtooth = isSawtooth(subArr);
                if (isSawtooth) {
                    count++;
                }
            }
        }

        return count;
    }

    static boolean isSawtooth(long[] arr) {
        //System.out.println("arr: " + Arrays.toString(arr));

        if (arr.length < 2 ) {
            return false;
        } else if (arr.length == 2) {
            if (arr[0] == arr[1]) {
                return false;
            } else {
                return true;
            }
        }
        boolean isSawtooth = true;
        boolean previousUpTendency = true;
        for (int i=1; i<arr.length; i++) {
            if (arr[i-1] == arr[i]) {
                isSawtooth = false;
                break;
            }

            boolean tendency = arr[i-1] < arr[i];
            //System.out.println("tendency: " + tendency + ", arr[i-1]: " + arr[i-1] + ", arr[i]: " + arr[i]);
            if (i==1) {
                previousUpTendency = tendency;
                continue;
            }

            if (previousUpTendency == tendency) {
                isSawtooth = false;
                break;
            }
            previousUpTendency = tendency;
        }
        return isSawtooth;
    }

}
