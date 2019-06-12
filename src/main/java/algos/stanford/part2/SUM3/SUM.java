package algos.stanford.part2.SUM3;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import static java.nio.file.Paths.*;

@SuppressWarnings("Duplicates")
public class SUM {


    public static void main(String[] args) throws IOException {
        SumOfTwo();
    }


    private static void SumOfTwo() throws IOException {

        List<String> lines = Files.readAllLines(get("/Users/platon/Desktop/3sumst"));
        Hashtable<Integer, Long> hashtable = new Hashtable<>();
        HashSet<Long> hashSet = new HashSet<>();
        TreeSet<Long> treeSet = new TreeSet<>();
        Long[] A = new Long[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            Long aLong = Long.valueOf(lines.get(i));
            A[i] = Long.valueOf(lines.get(i));
            hashtable.put(i, aLong);
            hashSet.add(aLong);
            treeSet.add(aLong);
        }

        //int[] interval = {-10000,10000};
        int[] interval = {0, 4};

        int i = -1;
        Hashtable<Integer, Numbers> res = new Hashtable<>();
        HashSet<Long> res2 = new HashSet<>();
        //HashSet<Numbers> res2 = new HashSet<>();

        for (Long l : hashSet) {
            for (int t = interval[0]; t <= interval[1]; t++) {
                if (hashSet.contains(t-l)) {
                    i++;

                    Numbers numbers = new Numbers();
                    numbers.setNum1((long)t);
                    numbers.setNum2(l);
                    numbers.setSum(t-l);

                    res2.add(t-l);
                    res.put(i,numbers);
                }
            }
        }


        HashSet<Long> longs = new HashSet<>();

        for (Long aLong : A) {
            for (int t = interval[0]; t <= interval[1]; t++) {

                if (hashtable.contains(t - aLong)) {
                    longs.add(aLong);
                    //System.out.println(t - aLong);
                    //System.out.println(hashtable.toString());
                }
            }
        }

        for (Long l : longs){
            System.out.println(l);
        }
        for (Integer h : res.keySet()) {
            System.out.println(res.get(h).getNum1()+"-"+res.get(h).getNum2()+"="+res.get(h).getSum());

        }

        //System.out.println();
        System.out.println("counts = " + res.size());
//
//        //Arrays.sort(a);
//        //System.out.println(Arrays.toString(a));
//        for (int x = 0; x < a.length; x++) {
//            //System.out.println(hashSet.contains(0L - a[x]));
//            //System.out.println(binarySearch(a,3L - a[x]));
//
//            for (int t = interval[0]; t <= interval[1]; t++) {
//                //System.out.println(i);
//                boolean search = binarySearch(a, 3 - a[x]);
//                //System.out.println(search);
//            }
//        }
//        int search = Arrays.binarySearch(a, 3 - 3L);

        //System.out.println(search);
    }

    private static boolean binarySearch(Long[] data, Long key) {
        int low = 0;
        int high = data.length - 1;

        while (high >= low) {
            int middle = (low + high) / 2;
            if (data[middle].equals(key)) {
                return true;
            }
            if (data[middle] < key) {
                low = middle + 1;
            }
            if (data[middle] > key) {
                high = middle - 1;
            }
        }
        return false;
    }
}
