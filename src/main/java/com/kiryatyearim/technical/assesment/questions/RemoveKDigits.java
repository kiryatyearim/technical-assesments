package com.kiryatyearim.technical.assesment.questions;

import com.kiryatyearim.datastructures.Stack;

public class RemoveKDigits {

    /**
     * Remove K digits from input to find the minimum value
     * @param args
     */
    public static void main(String[] args) {
        String input = "1432219";
        int k = 3;
        String result = removeKDigits(input, 3);

        System.out.println("result: " + result);

    }

    private static String removeKDigits(String input, int k) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        char[] ca = input.toCharArray();
        for (char c : ca) {
            int i = (int)c;
            while (k > 0 && !stack.isEmpty() && stack.peek() > i) {
                stack.pop();
                --k;
            }
            stack.push(c);
        }
        if (k > 0) {
            stack.pop();
        }

        StringBuilder result = new StringBuilder();
        for (int i=0; i<stack.size(); i++) {
            Character c = stack.get(i);
            result.append(c);
        }

        return result.toString();
    }

}
