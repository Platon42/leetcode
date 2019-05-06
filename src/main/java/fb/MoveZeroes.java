package fb;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        Queue<Integer> queue = new LinkedList<>();

        for (int num : nums) {
            if (num != 0) queue.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty()) nums[i] = queue.poll();
            else nums[i] = 0;
        }



        System.out.println(queue);
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(new int[] {0,1,0,3,12});
    }


}
