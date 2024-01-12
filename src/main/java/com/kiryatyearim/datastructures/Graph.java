package com.kiryatyearim.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    int[][] matrix;
    List<Node> nodes = new ArrayList<>();
    Graph(int size) {
        this.matrix = new int[size][size];
    }
    public void addNode(Node node) {
        this.nodes.add(node);
    }
    public void addEdge(int src, int dst) {
        this.matrix[src][dst] = 1;
    }
    public boolean checkEdge(int src, int dst) {
        return this.matrix[src][dst] == 1;
    }

    public void print() {
        System.out.print("  ");
        for (Node n : nodes) {
            System.out.print(n.data + " ");
        }
        System.out.println();

        for (int i=0; i<this.matrix.length; i++) {
            System.out.print(nodes.get(i).data + " ");
            for (int j=0; j<this.matrix[i].length; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void depthFirstSearch(int src) {
        boolean[] visited = new boolean[matrix.length];
        dfsHelper(src, visited);
    }

    public void dfsHelper(int src, boolean[] visited) {
        if (visited[src]) {
            return;
        } else {
            visited[src] = true;
            System.out.println(nodes.get(src).data + " node visited.");
        }

        for (int i=0; i<matrix[src].length; i++) {
            if (matrix[src][i] == 1) {
                dfsHelper(i, visited);
            }
        }
    }
    public void breadthFirstSearch(int src) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        queue.offer(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            src = queue.poll();
            System.out.println(nodes.get(src).data + " = visited");
            for (int i = 0; i<matrix[src].length; i++) {
                if (matrix[src][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
