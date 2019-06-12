package algos.stanford.part1.lesson3;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@SuppressWarnings("Duplicates")
public class QuikHigh {

    static LinkedHashMap<Double,Integer> acc = new LinkedHashMap<>();
    private static int countComparisons;

    private static void swap(int[] input, int i, int j) {

        final int t = input[i];
        input[i] = input[j];
        input[j] = t;

    }

    public static void main(String[] args) throws IOException {

        File f = new File("/Users/platon/Desktop/intq");
        List<String> lines2 = FileUtils.readLines(f, "UTF-8");
        ArrayList<Integer> arrayList = new ArrayList<>();

        int ln = 0;
        int[] inputArray = new int[lines2.size()+1];

        for (String line : lines2) {
            ln++;
            inputArray[ln]=Integer.valueOf(line);
            arrayList.add(Integer.valueOf(line));

       }
        //arrayList.sort(Comparator.naturalOrder());
//        for (int i : inputArray){
//            System.out.println("sort array="+i);
//        }
        //int[] inputArray = {199,85552,6,5,9,5,7676,3};
        //int[] inputArray = {18,822,66,55,9,5,7,3};

        int[] inputArraya = {82,2,10,9,7,3};

        System.out.println(inputArraya.length);


//        Scanner scanner = new Scanner(new File("/Users/platon/Desktop/intq"));
//        while (scanner.hasNextLine()) {
//
//            //System.out.println("string is="+scanner.nextLine());
//            ln++;
//            inputArray[ln]=Integer.valueOf(scanner.nextLine());
//
//        }

        sort(inputArray, 1, inputArray.length-1);

        for (int i : inputArray) {
            System.out.println("sort="+i);
        }

        System.out.println("comps="+countComparisons);
        //System.out.println("element are "+inputArray[1]);


    }

    private static void sort(int a[], int begin, int end) {
        if (begin < end) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pivotIndex = partition(a, begin, end);

            //System.out.println("pi is="+pivotIndex);
            // Recursively sort elements before
            // partition and after partition
            sort(a, begin, pivotIndex -1);
            sort(a, pivotIndex, end);



        }
    }
    private static int partition(int[] a, int begin, int end) {

        System.out.println("p="+end);

        int p = a[end];
        int i = begin - 1;
        countComparisons += (long) end - begin - 1;

        for (int j = begin; j < end; j++) {
            if (a[j] < p) {
                i++;
                swap(a,i,j);
            }
        }

        swap(a,end,i+1);

        return i+1;
    }

}
