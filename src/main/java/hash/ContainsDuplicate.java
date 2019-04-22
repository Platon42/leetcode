package hash;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> integerHashSet = new HashSet<>();

        for (int num : nums) {

            if (integerHashSet.contains(num)) return true;
            integerHashSet.add(num);

        }

        return false;
    }


}
