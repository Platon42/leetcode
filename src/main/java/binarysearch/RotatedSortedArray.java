package binarysearch;

@SuppressWarnings("Duplicates")
public class RotatedSortedArray {

    public int search(int[] nums, int target) {

        int left = 0, right = nums.length;
        boolean pivot = false;

        while (left <= right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
//            System.out.println(mid);
//            System.out.println(nums[mid]);
            if (nums[mid+1] < nums[mid]) pivot = true;
            System.out.println("pivot="+pivot);

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[mid+1] && !pivot) {
                System.out.println("else1="+mid);

                left = mid + 1;
            } else {
                System.out.println("else2="+mid);

                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotatedSortedArray rotatedSortedArray = new RotatedSortedArray();
        System.out.println(rotatedSortedArray.search(new int[]{1,2,3,4,5,0,1},0));
    }
}
