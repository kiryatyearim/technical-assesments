package com.kiryatyearim.technical.assesment.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountPairsQuestion {

    public static void main(String[] args) {
        int size = 100000;
        int[] input = new int[size];
        for (int i = 0; i<size; i++) {
            input[i] = i;
        }

        int[] input2 = new int[]{1, 2, 3, 4, 5};
        //long result = solution(input, 3);
        long result = solution2(input2, 3);

        System.out.println("result: " + result);
    }
    static long solution2(int[] a, int k) {
        Long counter = Long.valueOf(0);
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        int count = getAllPairs(list, k);
        return count;
    }

    static int getAllPairs(List<Integer> list, int k) {
        if (list.size() == 0) {
            return 0;
        }
        List<Integer> subList = list.subList(1, list.size());
        int count;
        count = getAllPairs(subList, k);
        for (Integer i : subList) {
            if ((list.get(0).intValue() + i.intValue())%k == 0) {
                System.out.println("count: " + count);
                count++;
            }
        }
        return count;
    }

    static long solution(int[] a, int k) {
        double max = Math.pow(10, 9);

        if (a.length < 1 || a.length > max) {
            return 0;
        }

        long count = 0;
        //System.out.println("a.length: " + a.length);

        long t1 = System.currentTimeMillis();
        for (int i=0; i<a.length; i++) {
            if (a[i] < 1 || a[i] > max) {
                continue;
            }
            for (int j=i+1; j<a.length; j++) {
                if (k==1 || k == (a[i]+a[j]) || (a[i]+a[j])%k == 0) {
                    count++;
                }
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("time: " + Long.toString((t2-t1)/1000));
        return count;


/*
        long t1 = System.currentTimeMillis();
        AtomicLong aCount = new AtomicLong(0);
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        Stream<Integer> s = Arrays.stream(a).boxed();

        AtomicInteger aIndex = new AtomicInteger(0);
        s.forEach(
                i -> { list.subList(aIndex.get(), a.length-1)
                        .stream().filter( j -> (a[i]+a[j])%k==0)
                        .forEach(j -> aCount.addAndGet(1));
                    aIndex.incrementAndGet();
                }
            );
        long t2 = System.currentTimeMillis();
        System.out.println("time: " + Long.toString((t2-t1)/1000));

        return aCount.get();
*/

    }

}
