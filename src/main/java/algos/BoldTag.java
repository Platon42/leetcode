package algos;

import java.util.*;
import java.util.function.Predicate;

class Pairs {
    Integer hi;
    Integer low;
    Integer prevHi;
    Integer prevLow;

}

public class BoldTag {

    public static void main(String[] args) {

        String s = "abcabcabczzzza123ab abc";
        String[] dict = {"abc", "123"};
        addBoldTag(s, dict);
    }


    private static void addBoldTag(String s, String[] dict) {

        LinkedHashMap<Long,TreeSet<Pairs>> linkedList = new LinkedHashMap<>();

        TreeSet<Pairs> pairsTreeSet = new TreeSet<>(new Comparator<Pairs>() {
            @Override
            public int compare(Pairs o1, Pairs o2) {
                //if (o1.hi + 1 == o2.low) return 0;
                return o1.low.compareTo(o2.low);
            }
        });


        for (int i = 0; i < dict.length; i++) {

            int low = s.indexOf(dict[i]);

            while (low != -1) {

                Pairs pairs = new Pairs();
                int hi = dict[i].length() + low - 1;
                pairs.hi = hi;
                pairs.low = low;

                pairsTreeSet.add(pairs);

                low = s.indexOf(dict[i], pairs.hi);

            }

        }

        Iterator<Pairs> pairsIterator = pairsTreeSet.iterator();
        Pairs current = pairsIterator.next();

        boolean include = true;

        if (!pairsIterator.hasNext()) {
            System.out.println(s.substring(current.low, current.hi + 1));
        }
        TreeSet<Pairs> neighbours = new TreeSet<>(new Comparator<Pairs>() {
            @Override
            public int compare(Pairs o1, Pairs o2) {
                return o1.low.compareTo(o2.low);
            }
        });
        int[] incArr = new int[1000];
        int inclCnt = -1;


        while (pairsIterator.hasNext()) {

            Pairs next = pairsIterator.next();
            long nanoTime = System.nanoTime();

            if (current.hi + 1 == next.low && include) {

                inclCnt++;
                neighbours.add(current);
                neighbours.add(next);

                linkedList.put(nanoTime,neighbours);

                //System.out.println("current low=" + current.low);
                //System.out.println("current hi=" + current.hi);
                //System.out.println("next low=" + next.low);
                //System.out.println("next hi=" + next.hi);

            } else {
                include = false;
                System.out.println("current low=" + current.low);
                System.out.println("current hi=" + current.hi);
                System.out.println("next low=" + next.low);
                System.out.println("next hi=" + next.hi);
            }

            current = next;
        }
        System.out.println(linkedList.size());

        for (TreeSet<Pairs> p : linkedList.values()) {
                System.out.println();
        }

    }


}
