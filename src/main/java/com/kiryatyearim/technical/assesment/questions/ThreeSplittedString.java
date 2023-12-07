package com.kiryatyearim.technical.assesment.questions;

public class ThreeSplittedString {
    public static void main(String[] args) {
        String input = "xzxzxzx";
        int result = solution(input);
        System.out.println("result: " + result);
    }

    static int solution(String s) {

        int end = s.length();
        int count = 0;
        for (int i=1; i<end-1; i++) {
            for (int j=i+1; j<end; j++) {
                String a = s.substring(0, i);
                String b = s.substring(i, j);
                String c = s.substring(j, end);
                System.out.println("a: " + a + ", b:" + b +", c:" + c);

                String ab = a+b;
                String bc = b+c;
                String ca = c+a;
                if (!ab.equals(bc) && !bc.equals(ca) && !ab.equals(ca)) {
                    count++;
                }
            }
        }

        return count;

    }
}
