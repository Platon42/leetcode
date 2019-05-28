package stanford.greedy;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@SuppressWarnings("Duplicates")
public class Jobs {

    static class Pairs {
        Float length;
        Float weight;
        Pairs(Float weight, Float length) {this.length = length; this.weight = weight;}

    }

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Platon\\Downloads\\jobs.txt"));
        LinkedList<Pairs> list = new LinkedList<>();

        for (String s : lines) {
            Float w = Float.valueOf(s.substring(0, s.indexOf(' ')));
            Float l = Float.valueOf(s.substring(s.indexOf(' ') + 1));
            list.add(new Pairs(w,l));
        }

        list.sort(pairsComparator);

        long c = 0L;
        long sum = 0L;

        Pairs p;

        for (int i = list.size() - 1; i >= 0; i--) {

            p = list.get(i);
            c += p.length.longValue();
            sum += c * p.weight.longValue();
            //System.out.println(" w = " + curr.weight + "curr length is = " +curr.length+" prev length is = "+prev.length + " c = " +c +" sum = " + sum);
            //System.out.println(" w = " + curr.weight + " curr length is = " +curr.length);

        }
        System.out.println(sum);
    }

    private static Comparator<Pairs> pairsComparator = new Comparator<Pairs>() {
        @Override
        public int compare(Pairs o1, Pairs o2) {
            Float d1 = o1.weight / o1.length;
            Float d2 = o2.weight / o2.length;
            if (d2.equals(d1)) {
                if (o1.weight > o2.weight)
                    return 1;
                else return -1;
            } else return d1.compareTo(d2);
        }
    };
}

