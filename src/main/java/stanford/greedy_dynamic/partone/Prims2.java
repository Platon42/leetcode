package stanford.greedy_dynamic.partone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@SuppressWarnings("Duplicates")

public class Prims2 {

    private static class Vertex {
        ArrayList<Edge> neighbors;

        private Vertex() {
            neighbors = new ArrayList<>();
        }
    }

    private static class Edge {
        Integer to, cost;

        private Edge(int end, int cost) {
            this.to = end;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Platon\\Downloads\\edges_greedy.txt"));

        int vertices = 500;
        int edges = 2184;

        Vertex[] graph = new Vertex[vertices + 1];

        for (int j = 0; j <= vertices; j++) {
            graph[j] = new Vertex();
        }

        int from = 0, to = 0, cost = 0;

        for (String line : lines) {
            String[] strings = line.split("\\s+");
            for (int j = 0; j < edges; j++) {
                from = Integer.valueOf(strings[0]);
                to = Integer.valueOf(strings[1]);
                cost = Integer.valueOf(strings[2]);
            }
            graph[from].neighbors.add(new Edge(to, cost));
            graph[to].neighbors.add(new Edge(from, cost));
        }

        int costt = PrimsAlgorithm(graph, 1);
        System.out.println(costt);

    }

    private static int PrimsAlgorithm(Vertex[] graph, int source) {
        // set the initial cost of the minimum spanning tree to 0
        int cost = 0;
        // initialize an array that will keep track of which vertices have been visited
        boolean[] visited = new boolean[graph.length];
        // initialize a PriorityQueue that will keep track of the possible edges that
        // we can add to the tree we are forming, and will allow us to select the
        // edge of least cost every step of the way
        // mark the initial vertex as visited
        visited[source] = true;

        // for every edge connected to the source, add it to the PriorityQueue
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost.compareTo(o2.cost);
            }
        });

        for (Edge edge : graph[source].neighbors) {
            priorityQueue.add(edge);
        }

        // keep adding edges until the PriorityQueue is empty
        while (!priorityQueue.isEmpty()) {
            Edge e = priorityQueue.poll();

            // if we have already visited the opposite vertex, go to the next edge
            if (visited[e.to]) continue;

            // mark the opposite vertex as visited
            visited[e.to] = true;
            // increment the cost by the cost of the edge we are adding to the graph
            cost += e.cost;

            // for every edge connected to the opposite vertex, add it to the PriorityQueue
            priorityQueue.addAll(graph[e.to].neighbors);
        }

        // if we haven't visited all of the vertices, return -1
        for (int i = 1; i < graph.length; i++) {
            if (!visited[i]) {
                return -1;
            }
        }

        // return the cost of the minimum spanning tree
        return cost;
    }
}
