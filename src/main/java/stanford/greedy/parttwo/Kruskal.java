package stanford.greedy.parttwo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@SuppressWarnings("Duplicates")
public class Kruskal {

    private static class Edge {

        Integer from;
        Integer to;
        Integer cost;

        Edge(Integer from, Integer to, Integer cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static class Graph {
        int vertices;
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph(int vertices) {
            this.vertices = vertices;
        }

        private void addEgde(int from, int to, int cost) {
            Edge edge = new Edge(from, to, cost);
            allEdges.add(edge); //add to total edges
        }
    }

    public static void main(String[] args) throws IOException {

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost.compareTo(o2.cost);
            }

        });

        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Platon\\Downloads\\edges_greedy.txt"));

        int vertices = 500;
        int edges = 2184;

        Graph graph = new Graph(vertices);
        int from = 0, to = 0, cost = 0;

        for (String line : lines) {
            String[] strings = line.split("\\s+");
            for (int j = 0; j < strings.length; j++) {
                from = Integer.valueOf(strings[0]);
                to = Integer.valueOf(strings[1]);
                cost = Integer.valueOf(strings[2]);
            }
            graph.addEgde(from, to, cost);
        }


        // Add all edges
        pq.addAll(graph.allEdges);

        //create a parent []
        int[] parent = new int[vertices + 1];

        //makeset
        makeSet(parent, vertices);

        int sum = 0;
        int index = 0;
        while (index < vertices - 1) {
            Edge edge = pq.remove();

            int x = find(parent, edge.from);
            int y = find(parent, edge.to);

            if (x == y) {
                //ignore, will create cycle
            } else {
                //add it to our final result
                index++;
                union(parent, x, y);
                sum += edge.cost;
            }
        }

        System.out.println(sum);
    }

    private static void makeSet(int[] parent, int vertices) {
        //Make set- creating a new element with a parent pointer to itself.
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }
    }

    private static int find(int[] parent, int vertex) {
        //chain of parent pointers from x upwards through the tree
        // until an element is reached whose parent is itself
        if (parent[vertex] != vertex) return find(parent, parent[vertex]);
        return vertex;
    }

    private static void union(int[] parent, int x, int y) {
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);
        //make x as parent of y
        parent[y_set_parent] = x_set_parent;
    }
}
