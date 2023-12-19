package com.kiryatyearim.technical.assesment.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaximumProductDifferenceBtwn2Pairs {

    public static void main(String[] args) {
        int[] input = {5,6,2,7,4};
        int result = maxProductDifference(input);
        System.out.println("result: " + result);
    }

    public static int maxProductDifference(int[] nums) {
        List<Integer> intNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        intNums.sort(Comparator.reverseOrder());
        int size = intNums.size();
        return intNums.get(0)*intNums.get(1) - intNums.get(size-1) * intNums.get(size-2);

    }

}
