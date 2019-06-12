package algos.stanford.part2.Dijkstra;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@SuppressWarnings("Duplicates")

public class Dijkstra {

    private static final int N = 201;
    private static int[] dist = new int[N];
    private static boolean[] visited = new boolean[N];

    private static LinkedList<Edge>[] G = new LinkedList[N];
    private static PriorityQueue<Edge> heap = new PriorityQueue<>(N, new Edge());
    private static Set<Integer> settled = new HashSet<>();

    private static void fillGraph(String filename) throws IOException {

        StringTokenizer st;
        List<String> lines = Files.readAllLines(Paths.get(filename));

        LinkedList<Edge> init = new LinkedList<>();

        init.add(new Edge(0, 0, 0));
        G[0] = init;

        for (int i = 0; i < lines.size(); i++) {

            String s = lines.get(i);
            String[] parts = s.split("\t");
            int start = Character.getNumericValue(s.charAt(0));
            LinkedList<Edge> edgeArrayList = new LinkedList<>();

            for (int j = 1; j < parts.length; j++) {

                st = new StringTokenizer(parts[j]);

                int E = Integer.valueOf(st.nextToken(","));
                int l = Integer.valueOf(st.nextToken());
                Edge edge = new Edge(start, E, l);
                edgeArrayList.add(edge);

            }
            G[i + 1] = edgeArrayList;
        }
    }

    private static void heapSearch(int start) {

        for (int i = 1; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        heap.offer(new Edge(start, start, 0));
        dist[start] = 0;
        //visited[start] = true;

        while (!heap.isEmpty()) {

            int u = heap.remove().getTargetVertex();
            if (!visited[u]) {

                for (int i = 0; i < G[u].size(); i++) {

                    int edgeDistance;
                    int newDistance;

                    Edge e = G[u].get(i);

                    edgeDistance = e.getDistance();
                    newDistance = dist[u] + edgeDistance;

                    if (newDistance < dist[e.getTargetVertex()] && !visited[e.getTargetVertex()]) {
                        dist[e.getTargetVertex()] = newDistance;
                        //System.out.println("new dist is "+ Arrays.toString(dist));

                    }
                    // Add the current node to the queue
                    heap.offer(new Edge(e.getStartVertex(), e.getTargetVertex(), dist[e.getTargetVertex()]));
                }
            }
            visited[u] = true;
        }

    }


    private static void getNeighbours(int u) {

        int edgeDistance;
        int newDistance;

        // All the neighbors of v

        for (int i = 0; i < G[u].size(); i++) {
            Edge e = G[u].get(i);
            //System.out.println("u is ="+u);
            // If current node hasn't already been processed
            //System.out.println("set is "+settled);
            //System.out.println("cur vertex "+ e.getTargetVertex());
            System.out.println(Arrays.toString(settled.toArray()));
            if (!settled.contains(e.getTargetVertex())) {
                //System.out.println("cur dist="+edgeDistance);

                edgeDistance = e.getDistance();
                newDistance = dist[u] + edgeDistance;
                //System.out.println("dist u ="+dist[u]);
                //System.out.println("dist="+newDistance);

                //int currentKey = dist[destination];
                // If new distance is cheaper in cost
                if (newDistance < dist[e.getTargetVertex()]) {
                    dist[e.getTargetVertex()] = newDistance;
                    //System.out.println("new dist is "+ Arrays.toString(dist));

                }
                // Add the current node to the queue
                heap.add(new Edge(e.getStartVertex(), e.getTargetVertex(), dist[e.getTargetVertex()]));
            }
        }
    }

    private static void printDijkstra(int[] distance, int sourceVertex) {
        System.out.println("Dijkstra Algorithm:");
        for (int i = 1; i < N; i++) {
            System.out.println("Source Vertex: " + sourceVertex + " to vertex " + +i +
                    " distance: " + distance[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        //7,37,59,82,99,115,133,165,188,197
        //6110,5256,4754,2052,2367,2399,2029,2442,6769,7044
        //2599,2610,2947,2052,2367,2399,2029,2442,2505,3068

        //23711,23209,36908,31621,28740,11462,20577,19299,27862,20787
        fillGraph("/Users/platon/Desktop/d");
        heapSearch(1);
        printDijkstra(dist, 1);
        //System.out.println("to dist="+dist[59]);
        //printDijkstra(dist, 1);


    }

}
