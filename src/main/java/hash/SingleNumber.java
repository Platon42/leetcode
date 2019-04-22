package hash;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class SingleNumber {

    public static int singleNumber(int[] nums) {

        HashSet<Integer> integerHashSet = new HashSet<>();

        int[] array = new int[nums.length/2];
        int dups = -1;

        for (int num : nums) {

            if (integerHashSet.contains(num)) {
                dups++;
                array[dups] = num;
            }

            integerHashSet.add(num);
        }

        for (int value : array) integerHashSet.remove(value);

        return integerHashSet.iterator().next();
    }

    public static void main(String[] args) {


        singleNumber(new int[]{4,1,2,1,2});

    }
}
