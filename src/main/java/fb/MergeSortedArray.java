package fb;

import java.util.*;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(n + m);

        for (int i = 0; i < m; i++) {
            priorityQueue.add(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
           priorityQueue.add(nums2[i]);
        }

        int j=0;

        while (!priorityQueue.isEmpty()) {
            nums1[j]= priorityQueue.poll();
            j++;
        }

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int [] a = {1,2,3,0,0,0};
        merge(a,3,new int[]{2,5,6},3);

        System.out.println(Arrays.toString(a));
    }
}
