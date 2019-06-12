package algos.stanford.part1;

import java.util.*;

public class Main {

/*    for i = 0 to N/2 − 1 do
            for j = 0 to P/2 − 1 do
    aij = a mod 2P
            a = ba/2
    P c
for j = P/2 to P − 1 do
    aij = 0
            for i = N/2 to N − 1 do
            for j = 0 to P − 1 do
    aij = 0
    ai = ai0 + ai1x + ai2x
2 + · · · + ai P −1x
    P −1*/

    public static void main(String[] args) {

        //String a = "3141592653589793238462643383279502884197169399375105820974944592";
        //String b = "2718281828459045235360287471352662497757247093699959574966967627";

        String a = "123";
        String b = "456";


        ArrayList<String> first = new ArrayList<>();
        ArrayList<String> second = new ArrayList<>();


        for (int i = 0; i < a.length(); i++) {
            int endindex = Math.min(i + 1, a.length());
            first.add(a.substring(i, endindex));
            second.add(b.substring(i, endindex));
        }

        LinkedHashMap<Integer, int[][]> acyclyc = new LinkedHashMap<>();

        int idx = 0;

        int[][] matrix = new int[second.size()][first.size() + second.size() -1];

        int[] m2 = new int[first.size() + second.size() -1];

        LinkedHashMap<Integer, int[]> hashMap = new LinkedHashMap<>();
        //System.out.println(m2.length);
        int a1;
        int b1;

        for (String sc : second) {
            b1 = Integer.parseInt(String.valueOf(sc));
            //idx
            //System.out.println("idx="+idx);
            for (int i = 0; i < first.size(); i++) {
                a1 = Integer.parseInt(first.get(i));
                //System.out.println("res="+a1*b1);
                //System.out.println("i="+i);]

                //matrix[][]=a1*b1;
                m2[m2.length-i-1]=a1*b1;
                System.out.println(m2[m2.length-i-1]);

//                for (int j = 0; j < m2.length; j++) {
//
//                }
//              m2[1]=a1*b1;
            }
            hashMap.put(idx,m2);

            //m2[]
                //hashMap.put(idx-1,)

        }
        for (Integer key : hashMap.keySet()){
            //System.out.println(key);
        }
        //System.out.println(hashMap.get(2)[2]);
        for (Integer l :hashMap.keySet()) {
            //System.out.println(l);

        }

    }



        /*for (String sc : second) {
            Integer b1 = Integer.parseInt(String.valueOf(sc));
            for (String fs : first) {

                idx++;
                lvl[3]=b1*a1;

                acyclyc.put(idx,lvl);
            }
        }*/

}
