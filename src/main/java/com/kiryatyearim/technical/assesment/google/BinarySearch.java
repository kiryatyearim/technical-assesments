package com.kiryatyearim.technical.assesment.google;

public class BinarySearch {

    public static void main(String[] args) {
        //int[] input = {1,4,5,7,9,12,15,18,19,22,25,29,40,50};
        int[] input = {1,4};
        int value = 1;
        System.out.println("*** targetVal: " + value + ", array size: " + input.length);
        int result = binarySearch(input, value, 0, input.length-1);
        System.out.println("*** Result index: " + result);
    }

    private static int binarySearch (int[] array, int targetVal, int minInx, int maxInx) {

        // base case: empty array
        if (array.length == 0) {
            return -1;
        }

        int mid = (maxInx + minInx)/2;
        // base case: accelerated case when array[mid] is the same as target value
        if (array[mid] == targetVal) {
            return mid;
        }

        // base case: last pair of values, check either one is the target value
        if (mid+1==maxInx) {
            if (array[mid+1]==targetVal) {
                return mid+1;
            }
            return -1;
        }

        // Recursive calls
        if (array[mid] > targetVal) {
            return binarySearch(array, targetVal, minInx, mid);
        } else {
            return binarySearch(array, targetVal, mid, maxInx);
        }
    }


}
