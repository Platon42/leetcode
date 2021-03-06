package stanford.greedy_dynamic;

import java.util.ArrayList;
import java.util.List;

class Item {

    protected String name;
    protected int value;
    protected int weight;

    protected Item(String name, int value, int weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    protected String str() {
        return name + " [value = " + value + ", weight = " + weight + "]";
    }

}

class Solution {

    // list of items to put in the bag to have the maximal value
    protected List<Item> items;
    // maximal value possible
    protected int value;

    protected Solution(List<Item> items, int value) {
        this.items = items;
        this.value = value;
    }

    protected void display() {
        if (items != null && !items.isEmpty()) {
            System.out.println("\nKnapsack solution");
            System.out.println("Value = " + value);
            System.out.println("Items to pick :");

            for (Item item : items) {
                System.out.println("- " + item.str());
            }
        }
    }

}

public class Knapsack2 {

    // items of our problem
    private Item[] items;
    // capacity of the bag
    private int capacity;

    public Knapsack2(Item[] items, int capacity) {
        this.items = items;
        this.capacity = capacity;
    }

    public void display() {
        if (items != null && items.length > 0) {
            System.out.println("Knapsack problem");
            System.out.println("Capacity : " + capacity);
            System.out.println("Items :");

            for (Item item : items) {
                System.out.println("- " + item.str());
            }
        }
    }

    // we write the solve algorithm
    public Solution solve() {
        int NB_ITEMS = items.length;
        // we use a matrix to store the max value at each n-th item
        int[][] matrix = new int[NB_ITEMS + 1][capacity + 1];

        // first line is initialized to 0
        for (int i = 0; i <= capacity; i++)
            matrix[0][i] = 0;

        // we iterate on items
        for (int i = 1; i <= NB_ITEMS; i++) {
            // we iterate on each capacity
            for (int j = 0; j <= capacity; j++) {
                if (items[i - 1].weight > j)
                    matrix[i][j] = matrix[i - 1][j];
                else
                    // we maximize value at this rank in the matrix
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - items[i - 1].weight]
                            + items[i - 1].value);
            }
        }

        int res = matrix[NB_ITEMS][capacity];
        int w = capacity;
        List<Item> itemsSolution = new ArrayList<>();

        for (int i = NB_ITEMS; i > 0 && res > 0; i--) {
            if (res != matrix[i - 1][w]) {
                itemsSolution.add(items[i - 1]);
                // we remove items value and weight
                res -= items[i - 1].value;
                w -= items[i - 1].weight;
            }
        }

        return new Solution(itemsSolution, matrix[NB_ITEMS][capacity]);
    }

    public static void main(String[] args) {
        // we take the same instance of the problem displayed in the image
        Item[] items = {new Item("Elt1", 4, 12),
                new Item("Elt2", 2, 1),
                new Item("Elt3", 2, 2),
                new Item("Elt4", 1, 1),
                new Item("Elt5", 10, 4)};

        Knapsack2 knapsack = new Knapsack2(items, 15);
        knapsack.display();
        Solution solution = knapsack.solve();
        solution.display();
    }
}