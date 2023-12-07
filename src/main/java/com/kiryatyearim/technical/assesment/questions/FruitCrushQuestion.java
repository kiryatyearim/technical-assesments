package com.kiryatyearim.technical.assesment.questions;

import java.util.ArrayList;
import java.util.List;

public class FruitCrushQuestion {
    public static void main (String args[]) {
        int[] input = {3,3,1,1,2};
        int[] result = crushFruit(input);
        System.out.println("Result: " + result.length);
    }

    public static int[] crushFruit(int[] ca) {
        if (ca.length < 2) {
            return ca;
        }

        List<Integer> array = new ArrayList<>();
        for (int i=0; i<ca.length; i++) {
            if (i+1==ca.length) {
                array.add(ca[i]);
                break;
            }
            if (ca[i] != ca[i+1]) {
                ++i;
                continue;
            }
            array.add(ca[i]);
        }

        if (array.size() == ca.length) {
            return ca;
        } else {
            return crushFruit(array.stream().mapToInt(i -> i).toArray());
        }
    }

}