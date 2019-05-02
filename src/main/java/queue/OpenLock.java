package queue;

import java.util.LinkedList;
import java.util.Queue;

public class OpenLock {

    public static void openLock(String[] deadends, String target) {

        //int [] code = new int[target.length()];
        Queue<Integer> bfs = new LinkedList<>();
        for (int i = 0; i < target.length(); i++) {
            int code = Character.getNumericValue(target.charAt(i));
            bfs.add(code);

        }
    }

    public static void main(String[] args) {
        openLock(new String[]{""},"1234");
    }
}
