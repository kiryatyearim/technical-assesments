package com.kiryatyearim.technical.assesment.questions;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CandleAndPlatesQuestion {

    public static void main(String[] args) {
        String input = "|||||******|**|****|******|*|*||*|******|*||**|***|***|**||*|**|***|*|*|**||***|******|*|||*****||||";
        int[][] queries = new int[][] {new int[] {79,89}};
        //int[] results = platesBetweenCandles(input, queries);
        //int[] results = platesBetweenCandlesRegExp(input, queries);
        int[] results = platesBetweenCandlesPositinalSum(input, queries);

        System.out.println("results: " + Arrays.toString(results));
    }

    public static int[] platesBetweenCandlesPositinalSum(String input, int[][] queries) {
        int[] results = new int[queries.length];
        int[] partialSum = new int[input.length()];
        int[] nextLeftCandlePostion = new int[input.length()];
        int[] nextRightCandlePostion = new int[input.length()];

        int startCount=0;
        int leftCandelPosition=-1;
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '*') {
                startCount++;
            }
            partialSum[i]=startCount;

            if(input.charAt(i) == '|') {
                nextLeftCandlePostion[i]=i;
                leftCandelPosition=i;
            } else {
                nextLeftCandlePostion[i]=leftCandelPosition;
            }
        }

        int rightCandelPosition=-1;
        for (int j=input.length()-1; j>=0; j--) {
            if(input.charAt(j) == '|') {
                nextRightCandlePostion[j]=j;
                rightCandelPosition=j;
            } else {
                nextRightCandlePostion[j]=rightCandelPosition;
            }
        }

        int inx = 0;
        for (int[] query : queries) {
            int leftCandel = nextRightCandlePostion[query[0]];
            int rightCandel = nextLeftCandlePostion[query[1]];

            if(leftCandel < 0 || rightCandel < 0) {
                results[inx]=0;
                inx++;
                continue;
            }

            int diffStars = partialSum[rightCandel] - partialSum[leftCandel];
            if (diffStars <= 0) {
                results[inx]=0;
            } else {
                results[inx]=diffStars;
            }
            inx++;
            //System.out.println("diffStars: " + diffStars);
        }
        //System.out.println("partialSum: " + Arrays.toString(partialSum) + ", nextLeftCandlePostion: " + Arrays.toString(nextLeftCandlePostion) + ", nextRightCandlePostion: " + Arrays.toString(nextRightCandlePostion));


        return results;
    }

    public static int[] platesBetweenCandlesRegExp(String s, int[][] queries) {
        String star = "*";
        int index = 0;
        int[] results = new int[queries.length];

        for(int[] i : queries) {
            int count = 0;
            if (i[0] >= i[1]) {
                results[index] = count;
                index++;
                continue;
            }
            String sub = s.substring(i[0], i[1] + 1);
            int firstCandleInx = sub.indexOf('|');
            int lastCandleInx = sub.lastIndexOf('|')+1;

            if (firstCandleInx < 0 || (lastCandleInx-1<=firstCandleInx)) {
                results[index] = count;
                index++;
                continue;
            }

            String validSub = sub.substring(firstCandleInx, lastCandleInx);
            System.out.println("validSub: " + validSub);

            Matcher matcher = Pattern.compile(star,  Pattern.LITERAL).matcher(validSub);


            while (matcher.find()) {
                count++;
            }
            results[index] = count;
            index++;
        }
        return results;
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {

        int[] results = new int[queries.length];

        int index = 0;
        //char star = '*';
        String star = "*";
        for(int[] i : queries) {
                String sub = s.substring(i[0], i[1]+1);
                int firstCandleInx = sub.indexOf('|');
                int lastCandleInx = sub.lastIndexOf('|')+1;
                String validSub = sub.substring(firstCandleInx, lastCandleInx);
                System.out.println("-validSub: " + validSub);

                //results[index] = recursiveCount(validSub, star, 0);

                results[index] = validSub.length() - validSub.replace(star, "").length();


/*
                for (int k=0; k<validSub.length(); k++) {
                    if (validSub.charAt(k) == star) {
                        results[index]++;
                    }
                }
*/
            index++;
        }

        return results;

    }

    private static int recursiveCount(String subStr, char star, int i) {
        if (subStr.length() == i) {
            return 0;
        }

        int count = 0;
        char c = subStr.charAt(i);

        if (star == c) {
            count++;
        }

        return count + recursiveCount(subStr, star, i+1);
    }
}
