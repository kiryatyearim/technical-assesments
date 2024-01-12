package com.kiryatyearim.datastructures;

import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Queue {
    static java.util.Queue<Integer> queue = new PriorityQueue<>();
    //static Queue<Integer> queue = new LinkedList<>();
    //static Queue<Integer> queue = new ArrayBlockingQueue<Integer>();

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9,10);

        // Enqueue
        stream.forEach(
                Queue::addToQueue
        );

        for (int i=0; i<queue.size(); i++) {
            System.out.println("peek: " + queue.peek());
            queue.poll();
        }

    }

    static void addToQueue(Integer i){
        queue.add(i);
        //queue.offer(i);
    }
}

