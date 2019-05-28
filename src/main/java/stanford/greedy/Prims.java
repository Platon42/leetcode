package stanford.greedy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {

    static class Edge {
        Integer left;
        Integer right;
        Integer cost;
        Edge(Integer left,Integer right, Integer cost){
            this.left = left;
            this.right = right;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {

        PriorityQueue<Edge> heap = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Platon\\Downloads\\edges_greedy.txt"));

        for (String s : lines) {
            Integer left = Integer.valueOf(s.substring(0, s.indexOf(' ')));
            Integer right = Integer.valueOf(s.substring(s.indexOf(' '),s.indexOf(' ')));
            Integer cost = Integer.valueOf(s.substring(s.indexOf(' ') + 1));

            System.out.println(left);
        }

        


    }
}
