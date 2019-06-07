package stanford.greedy.partone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {

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

    public static void main(String[] args) throws IOException {

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost.compareTo(o2.cost);
            }
        });

        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Platon\\Downloads\\edges_greedy.txt"));

        Edge[] edges = new Edge[2184];

        int from = 0, to = 0, cost = 0;

        for (int i = 0; i < lines.size(); i++) {
            String[] strings = lines.get(i).split("\\s+");
            for (int j = 0; j < strings.length; j++) {
                from = Integer.valueOf(strings[0]);
                to = Integer.valueOf(strings[1]);
                cost = Integer.valueOf(strings[2]);
            }
            edges[i] = new Edge(from, to, cost);
        }

        ArrayList<ArrayList<Edge>> G = createGraph(edges);

        // Add all edges of starting node.
        pq.addAll(G.get(1));

        //ArrayList<Edge> edges1 = G.get(0);

        //System.out.println(edges1.size());

        boolean[] marked = new boolean[G.size()];
        marked[1] = true;

        int sum = 0;
        ArrayList<Edge> mst = new ArrayList<>();
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            //System.out.println(edge.cost);

            if (marked[edge.to]) continue;
            marked[edge.from] = true;

            for (Edge e : G.get(edge.to)) {
                if (!marked[edge.to]) {
                    pq.add(e);
                }
            }
            marked[edge.to] = true;
            sum += edge.cost;
            mst.add(edge);
        }

        for (Edge ee : mst) {
            //sum += ee.cost;
            System.out.println(ee.from+" - "+ee.to+" : "+ee.cost);
        }
        System.out.println(sum);

    }

    private static ArrayList<ArrayList<Edge>> createGraph(Edge[] edges) {

        ArrayList<ArrayList<Edge>> G = new ArrayList<>();

        int length = edges.length * 2;

        for (int i = 0; i < length; ++i) {
            G.add(new ArrayList<>());
        }
        //G.get(0).add(edges[0]);
        //System.out.println(G.get(0).get(0).from);

        //System.out.println(G.get(0));
        for (Edge e : edges) {
            Edge other = new Edge(e.from, e.to, e.cost);
            //System.out.println(other.from);
            G.get(e.from).add(e);
            G.get(e.to).add(other);
           // System.out.println("Added edge ["+e.from+", "+e.to+" : "+e.cost+"] "+"["+e.to+", "+e.from+" : "+e.cost+"]");
        }

        return G;
    }
}
