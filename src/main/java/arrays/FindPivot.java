package arrays;

public class FindPivot {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;
        int left = 0;
        for(int i=0; i < nums.length; i++) {
            sum -= nums[i];
            System.out.println("left = "+left);
            System.out.println("sum = "+sum);
            if (left == sum) return i;
            left += nums[i];
            System.out.println("2 left = "+left);
            System.out.println("2 sum = "+sum);
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivot findPivot = new FindPivot();
        System.out.println(findPivot.pivotIndex(new int[]{0,0,1,2}));
    }
}