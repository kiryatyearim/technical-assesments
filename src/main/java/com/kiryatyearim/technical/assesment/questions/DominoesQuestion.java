package com.kiryatyearim.technical.assesment.questions;

import java.util.*;

public class DominoesQuestion {
    public static void main(String[] args) {
        char[] input = {'.','L','.','R','.','.','.','L','R','.','.','L','.','.'};

        pushDominoes(input);

        System.out.println("Result: " + Arrays.toString(input));
    }

    private static void pushDominoes(char[] input) {
        Queue<Object[]> queue =  new LinkedList<>();

        for(int i=0; i < input.length; i++) {
            char c = input[i];
            if (c == 'L' || c == 'R') {
                Object[] domino = {i, c};
                queue.offer(domino);
            }
        }

        while (!queue.isEmpty()) {
            Object[] d = queue.poll();
            Integer i = (Integer) d[0];
            Character c = (Character) d[1];

            if (c.equals('L') && i > 0 && input[i-1] == '.') {
                input[i-1] = 'L';
                queue.offer(new Object[]{i-1, 'L'});
            } else {
                if (c.equals('R') && i+1 < input.length && input[i+1] == '.') {
                    if (i+2 < input.length && input[i+2] == 'L') {
                        queue.poll();
                    } else {
                        input[i+1] = 'R';
                        queue.offer(new Object[]{i+1, 'R'});
                    }
                }
            }
        }
    }

}
