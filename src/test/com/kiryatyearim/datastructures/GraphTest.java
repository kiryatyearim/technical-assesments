package com.kiryatyearim.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    int size = 5;
    Graph graph;

    @BeforeEach
    private void init() {
        graph = new Graph(size);
        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));

        graph.addEdge(0, 1); // A -> B
        graph.addEdge(1, 2); // B -> C
        graph.addEdge(2, 3); // C -> D
        graph.addEdge(2, 4); // C -> E
        graph.addEdge(4, 0); // E -> A
        graph.addEdge(4, 2); // E -> C
    }

    @Test
    void breadthFirstSearch() {
        graph.breadthFirstSearch(0);
    }

    @Test
    void depthFirstSearch() {
        graph.depthFirstSearch(0);
    }
}