package binarysearch;

public class Sqrt {

    public static void main(String[] args) {

        //binarySearch(new int[]{1,3,5,6,7},3);
        mySqrt(78787);

    }

    public static int mySqrt(int x) {

        int left = 0, right = x;
        while (left < right - 1) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;

            System.out.println(mid);
            if (mid <= x / mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
        return left;
    }



    private static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // End Condition: left > right
        return -1;
    }

}
