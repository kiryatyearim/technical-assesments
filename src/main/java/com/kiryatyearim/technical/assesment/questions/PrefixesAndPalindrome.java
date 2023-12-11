package com.kiryatyearim.technical.assesment.questions;

public class PrefixesAndPalindrome {

    public static void main(String[] args) {
        String input = "aaacodedoc";
        String output = solution(input);
        System.out.println("output: " + output);
    }


    static String solution(String s) {

        String result = findPalindrome(s, 0);
        System.out.println("result: " + result);
        return result;
    }

    static String findPalindrome(String s, int index) {


        StringBuilder sb = new StringBuilder();

        String palindrome = s;

        String result = s;
        while (!palindrome.isEmpty()) {
            palindrome = getLongestPalindrome(result);
            System.out.println("palindrome: " + palindrome);
            result = result.replaceFirst(palindrome, "");
        }

        return result;

    }

    static String getLongestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        String palindrome = "";

        for (int i=0; i<s.length(); i++) {
            sb.append(s.charAt(i));
            if (i==0) {
                continue;
            }

            if (isPalindrome(sb.toString())) {
                palindrome = sb.toString();
            }

        }
        return palindrome;
    }

    static boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        String reverted = sb.toString();
        //System.out.println("reverted: " + reverted);

        return reverted.equals(s);
    }




}
