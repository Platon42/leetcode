package hash;

import java.sql.Array;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntersectionofTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {

        ArrayList<Integer> hashSet1 = new ArrayList<>();
        ArrayList<Integer> hashSet2 = new ArrayList<>();

        for (int value : nums1) hashSet1.add(value);
        for (int value : nums2) hashSet2.add(value);

        LinkedList<Integer> intersect = new LinkedList<>(hashSet1);
        intersect.retainAll(hashSet2);

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
