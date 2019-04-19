package hash;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntersectionofTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();

        Set<Integer> collect = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> collect2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        for (int value : nums1) hashSet1.add(value);
        for (int value : nums2) hashSet2.add(value);

        HashSet<Integer> intersect = new HashSet<>(collect);
        intersect.retainAll(collect2);

        int[] results = new int[intersect.size()];
        int cnt=-1;

        for (Integer i:intersect) {
            cnt++;
            results[cnt] = i;
            System.out.println(i);
        }

        return results;
    }

    public static void main(String[] args) {

        intersection(new int[]{4,9,5}, new int[] {9,4,9,8,4});

    }
}
