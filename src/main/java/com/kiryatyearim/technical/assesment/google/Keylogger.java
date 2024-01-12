package com.kiryatyearim.technical.assesment.google;

import java.util.*;

public class Keylogger {

    /**
     * Find tall possible passwords by finding all permutations for a given input in a keylogger
     * @param args
     */
    public static void main(String[] args) {
        char[] chars = {'w','q','a'};
        int[] counters = {3,2,1};

        Set<String> result = findPasswords(chars, counters);
        int combinations = result.size();// The number of combinations is: (total)! / (repeated1)! / (repeated2)! ... ex: {3,2,1} = (6!) / (3!) / (2!) = 60 total combinations
        System.out.println("***Total combinations: " + combinations);
    }

    private static Set<String> findPasswords(char[] chars, int[] counters) {

        int finalLength = 0;
        for (int counter : counters) {
            finalLength += counter;
        }
        Set<String> results = new HashSet<>();
        generatePasswords(chars, counters, new StringBuilder(), finalLength, results);
        return results;
    }

    private static void generatePasswords(char[] chars, int[] counters, StringBuilder sb, int length, Set<String> results) {
        if (sb.length() == length) {
            String s = sb.toString();
            System.out.println("***password: " + s);
            results.add(s);
        }

        for (int i=0; i<chars.length; i++) {
            String s = sb.toString();
            int count = s.length() - s.replace(String.valueOf(chars[i]), "").length();
            if (counters[i] == count)
                continue;

            // node visited
            sb.append(chars[i]); // push
            generatePasswords(chars, counters, sb, length, results);
            // this is to keep the tree level
            sb.deleteCharAt(sb.length()-1); // pop
        }
    }


}
