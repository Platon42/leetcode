package algos.stanford.part2.SUM3;

import java.util.List;
import java.util.TreeSet;

public class SUM3 {

    public List<List<Integer>> threeSum(int[] nums) {

        int[] A = {-1, 0, 1, 2, -1, -4};

        TreeSet<Integer> integers = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            integers.add(nums[i]);

        }

        final int i = -1;
        integers.parallelStream().forEach(x -> {
//            i++;
//            int left = i + 1;
//            int right = integers.size() - 1;


        });
        return null;
    }
}
