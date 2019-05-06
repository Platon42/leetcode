package fb;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        sort(nums, 0, nums.length - 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.min(nums[i], nums[i+1]);
            i++;
        }

        System.out.println(sum);
        return 1;
    }

    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }


        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        ArrayPartitionI arrayPartitionI = new ArrayPartitionI();
        arrayPartitionI.arrayPairSum(new int[]{1, 1, 1, 1});
    }
}
