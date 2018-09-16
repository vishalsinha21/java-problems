package org.vs.geeksforgeeks.graph.hashset;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class Graph {

    HashMap<Integer, Node> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addEdge(Integer source, Integer dest) {
        if (!vertices.containsKey(source)) {
            vertices.put(source, new Node(source));
        }
        vertices.get(source).adjacent.add(dest);
    }

    @Override
    public String toString() {
        return vertices.toString();
    }

    public void bfs(Integer source) {
        Node startNode = vertices.get(source);
        Queue<Node> queue = new LinkedList<>();

        queue.add(startNode);
        HashMap<Integer, Boolean> visited = new HashMap<>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (!visited.containsKey(node.value)) {
                visited.put(node.value, true);
                System.out.print(node.value + " ");

                ListIterator<Integer> iterator = node.adjacent.listIterator();

                while (iterator.hasNext()) {
                    Integer next = iterator.next();
                    queue.add(vertices.get(next));
                }
            }
        }

    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println(graph);
        graph.bfs(2);
    }
}

class Node {
    Integer value;
    LinkedList<Integer> adjacent;

    public Node(Integer value) {
        this.value = value;
        adjacent = new LinkedList<>();
    }

    @Override
    public String toString() {
        return adjacent.toString();
    }
}