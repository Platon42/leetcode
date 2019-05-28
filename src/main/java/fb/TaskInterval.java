package fb;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TaskInterval {

    public int leastInterval(char []  tasks, int n) {

        HashMap<Character,Integer> map = new HashMap<>();

        for (char c:tasks){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(26, Collections.reverseOrder());
        maxHeap.addAll(map.values());

        int cycles = 0;
        while (!maxHeap.isEmpty()) {

        }
        return 1;
    }
}
