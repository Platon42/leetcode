package stack;

import java.util.Stack;

public class NumberIslands {

    private static Stack<int[]> stack = new Stack<>();
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) return 0;
        int res = 0, n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && grid[i][j] != 'v') {
                    System.out.println("TTT");
                    res++;
                    DFS(grid, i, j);
                }
            }
        }
        System.out.println(res);
        return res;
    }

    private static void DFS(char[][] grid, int i_in, int j_in) {// Set 'v' to visited node in grid

        stack.add(new int[]{i_in, j_in});

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            int i = pop[0], j = pop[1];

            if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) continue;
            if (grid[i][j] == 'v' || grid[i][j] != '1') continue;

            grid[i][j] = 'v';
            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];
                stack.push(new int[]{x,y});
            }
        }
    }

    public static void main(String[] args) {
        numIslands(new char[][]{
                {'1', '1', '1', '1', '0'}
                , {'1', '1', '0', '1', '0'}
                , {'1', '1', '0', '0', '0'}
                , {'0', '0', '0', '0', '0'}
        });
    }
}
