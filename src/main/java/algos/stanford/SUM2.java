package leetcode;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Paths.get;

public class SUM2 {

    public static void main(String[] args) throws IOException {
/*
        List<String> lines = Files.readAllLines(get("/Users/platon/Desktop/3sums.txt"));
        TreeSet<Long> treeSet = new TreeSet<>();
        TreeSet<Long> result = new TreeSet<>();

        for (String line : lines) {
            Long aLong = Long.valueOf(line);
            treeSet.add(aLong);
        }

        int[] interval = {-10000,10000};
        //int[] interval = {3,10};
        treeSet.parallelStream().forEach(x->{
            for (int t = interval[0]; t <= interval[1]; t++) {
                if (treeSet.contains(t-x)) {
                    result.add((long)t);
                }
            }
        });

        System.out.println(result.size());
     */
        int[] numbers = {3, 2, 3};
        int[] kfreq = {1, 1, 1, 5, 100, 100, 5, 101, 101, 101, 101, 101, 100, 5, 5, 100,100, 6, 6, 6, 6, 6, 100, 6, 6, 3};
        topKFrequent(kfreq, 2);

        //twoSum(numbers, 6);
    }

    private static void twoSum(int[] nums, int target) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        int x = 0, y = 0;
        for (int num : nums) {
            x = target - num;
            if (treeSet.contains(x)) {
                y = num;
                break;
            } else {
                treeSet.add(num);
            }
        }
        int firstIndex = 0, secondIndex = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == x) {
                firstIndex = i;
            }
            if (nums[i] == y) {
                secondIndex = i;
            }
        }
        System.out.println(x + " " + y);
        System.out.println(Arrays.toString(nums));
        System.out.println(firstIndex + " " + secondIndex);


    }
||
    public static void topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> duplicates = new HashMap<>();
        Arrays.stream(nums).forEach(key -> {
            if (duplicates.containsKey(key)) {
                duplicates.put(key, duplicates.get(key) + 1);
            } else {
                duplicates.put(key, 1);
            }


        });

        HashMap<Integer, Integer> map = duplicates;
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entries : map.entrySet()) {
            if (heap.size() == k && Objects.requireNonNull(heap.peek()).getValue() < entries.getValue()) heap.poll();
            if (heap.size() < k) heap.offer(entries);

        }
        for(int i = 0; i < k; i++){
            result.add(Objects.requireNonNull(heap.poll()).getKey());
        }

        for (Integer integer : result) {
            System.out.println(integer);
        }

    }

    void descInsertSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
                while (j > 0 && arr[j - 1] < key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

}