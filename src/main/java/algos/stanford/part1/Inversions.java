package algos.stanford.part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inversions {
    static ArrayList<Integer> acc = new ArrayList<>();
    //static int inv = 0;

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        //assert isSorted(a, lo, mid); // precondition: a[lo..mid] sorted
        //assert isSorted(a, mid+1, hi); // precondition: a[mid+1..hi] sorted


        int inv = 0;

//        for (int k = lo; k <= hi; k++){
//            aux[k] = a[k];
//        }
        //System.out.println("first half="+a[i]);
        //System.out.println("second half="+a[j]);
        System.out.println("hi is=" + hi);
        System.out.println("mid is=" + mid);
        System.out.println("lo is=" + lo);

        int k = lo;
        int i = lo, j = mid + 1;

        System.out.println("first k=" + k);

        while (i <= mid && j <= hi) {
            if (a[i] < a[j]) {
                aux[k++] = a[i++];
                System.out.println("Element i are=" + a[k]);

            } else {
                aux[k++] = a[j++];
                System.out.println("Element j are=" + a[k]);
                //j++;
                //acc.add(aux.length - i);
                //total = total.add(new BigDecimal(leftArray.length - i));
            }
        }
        System.out.println("second k=" + k);
        System.out.println("lo=" + lo);
        inv = (k - lo);

        acc.add(inv);

        while (i <= mid) {
            aux[k++] = a[i++];
            System.out.println("first copy loop");

        }

		/* Copy the remaining elements of right subarray
	(if there are any) to temp*/
        while (j <= hi) {
            System.out.println("second");
            aux[k++] = a[j++];

        }

        /*Copy back the merged elements to original array*/
        for (i = lo; i <= hi; i++) {
            a[i] = aux[i];
            System.out.println(Arrays.toString(a));
        }

        /*
        for (int k = lo; k <= hi; k++) {

            if (i > mid) {
                a[k] = aux[j++];
                System.out.println("i>mid="+a[k]);
            } else if (j > hi) {
                a[k] = aux[i++];

                System.out.println("j>hi="+a[k]);
                System.out.println("mid="+mid);
                inv++;

                acc.add(inv);

            } else if (aux[j]<(aux[i])) {
                System.out.println("compare="+a[k]);
                a[k] = aux[j++];
                inv++;

                acc.add(inv);

            } else {
                System.out.println("else="+a[k]);
                a[k] = aux[i++];
                inv=inv
                acc.add(inv);

            }

        }
        */
        //System.out.println("inv=" +inv);
        //assert isSorted(a, lo, hi); // postcondition: a[lo..hi] sorted
    }

    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;

        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("/Users/platon/Desktop/int2"));

        int ln;
        for (String s : lines) {

            ln = s.length();

            //Comparable[] in = new Comparable[ln];
            //Comparable[] aux = new Comparable[ln];
            int[] in = new int[ln];
            // int[] aux = new int[ln];
            for (int i = 0; i < ln; i++) {
                int num = Integer.valueOf(String.valueOf(s.charAt((i))));
                in[i] = num;
            }
            int sum = acc.stream().mapToInt(Integer::intValue).sum();

        }

        int[] input = {5, 3, 8, 9, 1, 7, 0, 2, 6, 4};
        int[] aux = new int[input.length];
        sort(input, aux, 0, input.length - 1);

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }


        //sum=sum+1;
        //System.out.println("inv is " + sum);

    }

}
