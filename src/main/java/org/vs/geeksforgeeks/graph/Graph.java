package org.vs.geeksforgeeks.graph;

import java.util.LinkedList;

public class Graph {

    int vertices;
    LinkedList<Integer>[] edges;

    public Graph(int vertices) {
        this.vertices = vertices;
        edges = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            edges[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        edges[src].addLast(dest);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < vertices; i++) {
            builder.append(i + " -> " + edges[i] + "\n");
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);

        graph.addEdge(1, 0);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);

        graph.addEdge(2, 1);
        graph.addEdge(2, 3);

        graph.addEdge(3, 4);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);

        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 3);

        System.out.println(graph);
    }
}
