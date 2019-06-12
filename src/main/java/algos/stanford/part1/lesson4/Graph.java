package algos.stanford.part1.lesson4;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

/*
1 2 3 4 7
2 1 3 4
3 1 2 4
4 1 2 3 5
5 4 6 7 8
6 5 7 8
7 1 5 6 8
8 5 6 7

*/
public class Graph {
    private int vertex;
    private LinkedList<Integer>[] list;

    public Graph(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for (int i = 0; i <vertex ; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){

        //add edge
        list[source].addFirst(destination);

        //add back edge ((for undirected)
        list[destination].addFirst(source);
    }

    public void printGraph(){
        for (int i = 0; i <vertex ; i++) {
            if(list[i].size()>0) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        HashMap<Integer,List<Integer>> hashMap = new HashMap<>();

        File f = new File("/Users/platon/Desktop/gr");
        List<String> lines2 = FileUtils.readLines(f, "UTF-8");

        int idx = 0;

        List<Integer> integerList = new LinkedList<>();

        for (String line : lines2) {
            idx++;
            integerList = new LinkedList<>();
            for (int i = 1; i < line.length(); i++) {
                int e = Integer.parseInt(String.valueOf(line.charAt(i)));
                integerList.add(e);
            }

            hashMap.put(idx,integerList);
        }

        //System.out.println(src[8][1]);

        Graph graph = new Graph(10);

        for (int key : hashMap.keySet()){
            List<Integer> list = hashMap.get(key);
            //System.out.println("key is ="+key);
            for (Integer value : list) {
                //System.out.println("value is ="+value);
                graph.addEdge(key, value);
            }
        }

        graph.printGraph();

    }
}