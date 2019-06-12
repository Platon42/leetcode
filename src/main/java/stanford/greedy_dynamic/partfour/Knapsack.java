package stanford.greedy_dynamic.partfour;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Knapsack {

    private static class Item {
        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    //initial capacity and items
    private static int SIZE = 0, ITEMS = 0;

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Platon\\Downloads\\knapsack1.txt"));
        LinkedList <Item> items = new LinkedList<>();

        //fill array
        String[] params = lines.get(0).split("\\s+");

        SIZE = Integer.valueOf(params[0]);
        ITEMS = Integer.valueOf(params[1]);

        int value, weight;
        Item item = null;

        for (int i = lines.size() - 1; i >= 1; i--) {
            String[] strings = lines.get(i).split("\\s+");
            for (int j = strings.length - 1; j >= 0; j--) {
                value = Integer.valueOf(strings[0]);
                weight = Integer.valueOf(strings[1]);
                item = new Item(value,weight);
            }
            items.add(item);
        }

        int[][] A = new int[ITEMS + 1][SIZE + 1];

        //initialize knapsack
        for (int i = 0; i < SIZE; i++) {
            A[0][i] = 0;
        }

        for (int i = 1; i <= ITEMS; i++) {
            for (int x = 0; x <= SIZE; x++) {
                if (items.get(i - 1).weight > x ) {
                    A[i][x] = A[i - 1][x];
                    //items.remove(i - 1);
                } else {
                    A[i][x] = Math.max(A[i - 1][x], A[i - 1][x - items.get(i - 1).weight] + items.get(i - 1).value);
                    //items.remove(i - 1);
                }
            }
        }

        System.out.println(A[ITEMS][SIZE]);

//        int res = A[ITEMS][SIZE];
//        int w = SIZE;
//
//        List<Item> itemsSolution = new ArrayList<>();
//
//        for (int i = ITEMS; i > 0 && res > 0; i--) {
//            if (res != A[i - 1][w]) {
//                itemsSolution.add(items.get(i - 1));
//                // we remove items value and weight
//                res -= items.get(i - 1).value;
//                w -= items.get(i - 1).weight;
//            }
//        }
//
//        //System.out.println(itemsSolution.size());
//
//        for (Item item1: itemsSolution) {
//            System.out.println("[value = " + item1.value + ", weight = " + item1.weight + "]");
//        }
    }

    private static int getMaxValue(int[][] numbers) {
        int maxValue = numbers[0][0];
        for (int[] number : numbers) {
            for (int value : number) {
                if (value > maxValue) {
                    maxValue = value;
                }
            }
        }
        return maxValue;
    }
}
