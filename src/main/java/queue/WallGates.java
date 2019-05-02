package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class WallGates {

    public static void wallsAndGates(int[][] rooms) {

        Queue<int[]> bfs = new LinkedList<>();

        int m = rooms.length, n = rooms[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    bfs.add(new int[]{i, j});
                    //visited[i][j] = true;

                }
                //else rooms[i][j] = Integer.MAX_VALUE;
            }
        }

        while (!bfs.isEmpty()) {

            int[] top = bfs.poll();
            System.out.println(Arrays.toString(top));

            for (int[] d : directions) {

                int row = top[0] + d[0];
                int col = top[1] + d[1];

                int[] rows = new int[]{row,col};
                System.out.println("ROW = "+row);
                System.out.println("DO = "+d[0]);
                System.out.println("D1 = "+d[1]);
                System.out.println("COL = "+col);

                //System.out.println(Arrays.toString(rows));
                // if new cell is out of bounds or is already closer to another 0, stop further bfs in this cell
                if(row < 0 || row >= m || col < 0 || col >= n || rooms[row][col] != Integer.MAX_VALUE) continue;
                bfs.add(new int[]{row, col});
                rooms[row][col] = rooms[top[0]][top[1]] + 1; // update new smaller distance
            }
        }
    }

    public static void main(String[] args) {
        wallsAndGates(new int[][]{
                {Integer.MAX_VALUE,-1,0,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},
                {Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1},
                {0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}});

    }

}
