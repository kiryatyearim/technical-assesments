package com.kiryatyearim.technical.assesment.questions;

public class NumbersCrushQuestion {
    public static void main (String args[]) {
        //String input = "111000";
        String input = "1010101111000000000000000000000111111111111111111111110111111111010101111111111000";

        char[] result = crushNumbers(input.toCharArray());
        System.out.println("Result: " + result.length);
    }

    public static char[] crushNumbers(char[] ca) {
        if (ca.length < 2) {
            return ca;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<ca.length; i++) {
            if (i+1==ca.length) {
                sb.append(ca[i]);
                break;
            }
            if (ca[i] != ca[i+1]) {
                ++i;
                continue;
            }
            sb.append(ca[i]);
        }

        if (sb.length() == ca.length) {
            return ca;
        } else {
            return crushNumbers(sb.toString().toCharArray());
        }
    }

}