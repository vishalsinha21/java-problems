package org.vs.geeksforgeeks.graph.bfs;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class Graph {

    int vertices;
    LinkedList<Integer>[] adj;

    public Graph(int vertices) {
        this.vertices = vertices;
        adj = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adj[src].addLast(dest);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < vertices; i++) {
            builder.append(i + " -> " + adj[i] + "\n");
        }

        return builder.toString();
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            System.out.print(vertex + " ");
            ListIterator<Integer> iterator = adj[vertex].listIterator();

            while (iterator.hasNext()) {
                Integer nextVertex = iterator.next();

                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                }
            }
        }

        System.out.println();
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        dfsUtil(start, visited);
        System.out.println();
    }

    private void dfsUtil(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");
        ListIterator<Integer> iterator = adj[start].listIterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (!visited[next]) {
                dfsUtil(next, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println(graph);

        graph.bfs(2);
        graph.dfs(2);
    }
}
