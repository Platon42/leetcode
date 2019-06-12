package algos.stanford.part2.SCC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@SuppressWarnings("Duplicates")
class SCC {


    private final static int vertex = 875714;
    private static ArrayList<Integer>[] data = new ArrayList[vertex];
    private static ArrayList<Integer>[] reversed = new ArrayList[vertex];

    private static int[] finishingTime = new int[vertex];
    private static int[] leader = new int[vertex];

    private static boolean[] visited = new boolean[vertex];
    private static int[] nodes = new int[vertex];

    private static Integer t = 0;
    private static Integer s = null;

    private static void readFile (String fileName) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(fileName));

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String str;
        StringTokenizer st;

            for (int i=0; i<vertex; i++){
                data[i] = new ArrayList<>();
                reversed[i] = new ArrayList<>();
            }


        while((str = br.readLine()) != null){
            st = new StringTokenizer(str);
            Integer i = Integer.valueOf(st.nextToken());
            Integer j = Integer.valueOf(st.nextToken());
            data[i-1].add(j-1);
            reversed[j-1].add(i-1);
        }
        br.close();
    }


    private static void transpose() {

        for (int u = 0; u < vertex; u++) {
            for (int v : data[u]) {
                reversed[v].add(u);
            }
        }
    }

    private void printGraph() {
        for (int i = 0; i < vertex; i++) {
            if (data[i].size() > 0) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (int j = 0; j < data[i].size(); j++) {
                    System.out.print(data[i].get(j) + " ");
                }
                System.out.println();
            }
        }
        for (int i = 0; i < vertex; i++) {
            if (reversed[i].size() > 0) {
                System.out.print("Transpose vertex " + i + " is connected to: ");
                for (int j = 0; j < reversed[i].size(); j++) {
                    System.out.print(reversed[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    private static void dfs(int iteration, int node_index) {

        visited[node_index] = true;
        leader[node_index] = s;

        if (iteration == 1) {
            for (int next : reversed[node_index]) {
                if (!visited[next]) {
                    dfs(1, next);
                }
            }
            finishingTime[node_index] = t++;
        }

        if (iteration == 2) {
            for (int next : data[node_index]) {
                if (!visited[next]) {
                    dfs(2, next);
                }
            }
            finishingTime[node_index] = t++;
        }
    }

    private static void copyNodes() {

        for (int i = 0; i < vertex; i++) {
            nodes[finishingTime[i]] = i;
        }

    }

    private static void clearVisited() {
        for (int i = 0; i < vertex; i++) visited[i] = false;
    }

    private static void dfsLoop(int iter) {

        for (int k = vertex - 1; k >= 0; k--) {
            if (iter == 1) {
                int i = k;
                if (!visited[i]) {
                    s = i;
                    dfs(1, i);
                }
            }
            if (iter == 2) {
                int i = nodes[k];
                if (!visited[i]) {
                    s = i;
                    dfs(2, i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        readFile("/Users/platon/Desktop/SCC.txt.1");
        //transpose();

        dfsLoop(1);

        clearVisited();
        System.out.println("orig is="+Arrays.toString(data));


        copyNodes();
        System.out.println("le is="+Arrays.toString(leader));

        dfsLoop(2);

        System.out.print("The sizes of the 5 largest SCC's are : ");
        Arrays.sort(leader);

        ArrayList<Integer> stat = new ArrayList<>();
        int pre = 0;
        for (int i = 0; i < vertex-1; i++) {
            if (leader[i] != leader[i + 1]) {
                stat.add(i - pre + 1);
                pre = i + 1;
            }
        }

        stat.add(vertex - pre);
        Integer[] s1 = stat.toArray(new Integer[0]);
        int[] s = new int[s1.length];
        for (int i = 0; i < s1.length; i++) s[i] = s1[i];
        Arrays.sort(s);
        int i = s.length - 1, j = 0;
        /* print only the top 5 largest SCC's */
        for (; j < 5; j++, i--) System.out.print(s[i] + " ");
        System.out.println();
    }


}
